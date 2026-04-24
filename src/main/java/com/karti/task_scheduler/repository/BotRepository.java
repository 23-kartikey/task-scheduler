package com.karti.task_scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karti.task_scheduler.entity.Bot;

public interface BotRepository extends JpaRepository<Bot, Long>{
    
}
