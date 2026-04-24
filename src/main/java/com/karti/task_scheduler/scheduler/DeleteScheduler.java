package com.karti.task_scheduler.scheduler;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.karti.task_scheduler.entity.Status;
import com.karti.task_scheduler.entity.Task;
import com.karti.task_scheduler.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Component
public class DeleteScheduler {
    
    private final TaskRepository repo;
    private static final Logger logger=LoggerFactory.getLogger(DeleteScheduler.class);

    public DeleteScheduler(TaskRepository repo){
        this.repo=repo;
    }

    @Scheduled(fixedDelay=30000, initialDelay=10000)
    @Transactional
    public void deleteFailed(){
        List<Task> tasks=repo.findByStatus(Status.FAILED);
        deleteFailedNow();
        logger.info("-----FAILED TASKS DELETED FROM DATABASE-----");
        for(Task task: tasks){
            logger.info("DELETED: "+task.getTitle()+" "+task.getId());
        }
    }

    public void deleteFailedNow(){
        repo.deleteByStatus(Status.FAILED);
    }

}
