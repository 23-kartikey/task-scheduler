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

import com.karti.task_scheduler.entity.Bot;
import com.karti.task_scheduler.repository.BotRepository;

@RestController
@RequestMapping("/bot")
public class BotController {
    
    @Autowired
    private BotRepository repo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bot newBot(@RequestBody Bot bot){
        return repo.save(bot);
    }

    @GetMapping
    public ResponseEntity<List<Bot>> getBots(){
        return ResponseEntity.ok(repo.findAll());
    }

}
