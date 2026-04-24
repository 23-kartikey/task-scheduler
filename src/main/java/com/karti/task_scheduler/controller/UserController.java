package com.karti.task_scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.karti.task_scheduler.entity.User;
import com.karti.task_scheduler.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository repo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user){
        return repo.save(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(repo.findAll());
    }

}
