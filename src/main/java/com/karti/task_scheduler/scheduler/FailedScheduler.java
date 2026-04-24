package com.karti.task_scheduler.scheduler;


import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.karti.task_scheduler.entity.Status;
import com.karti.task_scheduler.entity.Task;
import com.karti.task_scheduler.repository.TaskRepository;

@Component
public class FailedScheduler {
    
    private static final Logger logger=LoggerFactory.getLogger(FailedScheduler.class);
    private final TaskRepository repo;
    private final TaskScheduler scheduler;

    public FailedScheduler(TaskRepository repo, TaskScheduler scheduler){
        this.repo=repo;
        this.scheduler=scheduler;
    }

    // @PostConstruct
    // public void failedScheduler(){
    //     scheduler.scheduleAtFixedRate(()->checkFailed(), Duration.ofSeconds(5));
    //     scheduler.scheduleAtFixedRate(()->failTasks(), Duration.ofSeconds(20));
    // }

    @Scheduled(fixedRate=10000)
    public void checkFailed() throws InterruptedException{
        logger.info("Checking for failed tasks:::");
        List<Task> tasks=repo.findByRetryCountIsAndStatusIs(3, Status.FAILED);
        for(Task task: tasks){
            logger.info("Task failed: "+task.getTitle());
        }
    }

    @Scheduled(fixedRate=10000)
    public void increaseRetry() throws InterruptedException{
        logger.info(":INCREASING RETRY COUNT: ");
        List<Task> tasks=repo.findByReminderTimeBeforeAndStatusIsAndRetryCountLessThan(LocalDateTime.now(), Status.PENDING, 3);
        for(Task task: tasks){
            logger.info("Increased retry count: "+task.getTitle()+" "+task.getId());
            task.setRetryCount(task.getRetryCount()+1);
            repo.save(task);
        }
    }

    @Scheduled(fixedRate=30000)
    public void failTasks(){
        logger.info("---STARTING FAILING TASKS---");
        List<Task> tasks=repo.findByReminderTimeBeforeAndStatusIsAndRetryCountGreaterThan(LocalDateTime.now(), Status.PENDING, 2);
        for(Task task: tasks){
            task.setStatus(Status.FAILED);
            repo.save(task);
            logger.info("TASK SET TO FAILED: "+task.getTitle()+" "+task.getId());
        }
    }
    

}
