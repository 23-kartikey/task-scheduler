package com.karti.task_scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karti.task_scheduler.entity.Task;
import com.karti.task_scheduler.repository.TaskRepository;

@Service
public class TaskService {
    
    private final TaskRepository repo;

    public TaskService(TaskRepository repo){
        this.repo=repo;
    }

    public void saveTask(Task task){
        repo.save(task);
    }

    public List<Task> getTasks(){
        return repo.findAll();
    }

}
