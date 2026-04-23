package com.karti.task_scheduler.scheduler;


import java.time.Duration;
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
public class FailedScheduler {
    
    private static final Logger logger=LoggerFactory.getLogger(FailedScheduler.class);
    private final TaskRepository repo;
    private final TaskScheduler scheduler;

    public FailedScheduler(TaskRepository repo, TaskScheduler scheduler){
        this.repo=repo;
        this.scheduler=scheduler;
    }

    @PostConstruct
    public void failedScheduler(){
        scheduler.scheduleAtFixedRate(()->checkFailed(), Duration.ofSeconds(5));
    }

    public void checkFailed(){
        List<Task> tasks=repo.findByRetryCountGreaterThanAndStatusNot(2, Status.FAILED);
        for(Task task: tasks){
            logger.info("Task failed: "+task);
        }
    }
    

}
