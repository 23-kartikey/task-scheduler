package com.karti.task_scheduler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karti.task_scheduler.entity.Task;
import com.karti.task_scheduler.service.TaskService;

@RestController
public class TaskController {
    
    private final TaskService service;

    public TaskController(TaskService service){
        this.service=service;
    }

    public ResponseEntity<?> saveTask(@RequestBody Task task){
        service.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
