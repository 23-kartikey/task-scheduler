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
public class ReminderScheduler {
    
    private final TaskScheduler scheduler;
    private final TaskRepository repo;
    private static final Logger logger=LoggerFactory.getLogger(ReminderScheduler.class);

    public ReminderScheduler(TaskScheduler scheduler, TaskRepository repo){
        this.scheduler=scheduler;
        this.repo=repo;
    }

    // @PostConstruct
    // public void reminderScheduler(){
    //     scheduler.scheduleAtFixedRate(()->checkTasks(), Duration.ofSeconds(10));
    // }

    @Scheduled(fixedRate=10000)
    public void checkTasks() throws InterruptedException{
        logger.info("LOGGING INCOMPLETE TASKS:-->");
        List<Task> tasks=repo.findByReminderTimeBeforeAndStatusIs(LocalDateTime.now(), Status.PENDING);
        for(Task task: tasks){
            logger.info("Incomplete: "+task.getId()+" "+task.getTitle()+", "+task.getRetryCount()+" "+task.getStatus().toString());
        }
    }

}
    