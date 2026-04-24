package com.karti.task_scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karti.task_scheduler.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
