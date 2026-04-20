package com.karti.task_scheduler.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karti.task_scheduler.entity.Task;
import com.karti.task_scheduler.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    private final TaskService service;

    public TaskController(TaskService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<?> saveTask(@RequestBody Task task){
        service.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(service.getTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTasks(@PathVariable Long id){
        return ResponseEntity.ok(service.getTasks(id));
    }
}
