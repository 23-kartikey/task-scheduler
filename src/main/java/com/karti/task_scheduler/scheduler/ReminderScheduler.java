package com.karti.task_scheduler.scheduler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import com.karti.task_scheduler.entity.Status;
import com.karti.task_scheduler.entity.Task;
import com.karti.task_scheduler.repository.TaskRepository;
import jakarta.annotation.PostConstruct;

@Component
public class ReminderScheduler {
    
    private final TaskScheduler scheduler;
    private final TaskRepository repo;
    private static final Logger logger=LoggerFactory.getLogger(ReminderScheduler.class);

    public ReminderScheduler(TaskScheduler scheduler, TaskRepository repo){
        this.scheduler=scheduler;
        this.repo=repo;
    }

    @PostConstruct
    public void reminderScheduler(){
        scheduler.scheduleAtFixedRate(()->checkTasks(), Duration.ofSeconds(5));
    }

    public void checkTasks(){
        List<Task> tasks=repo.findByReminderTimeBeforeAndStatusNot(LocalDateTime.now(), Status.COMPLETED);
        for(Task task: tasks){
            logger.info("Incomplete: "+task.getTitle());
        }
    }

}
