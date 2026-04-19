package com.karti.task_scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karti.task_scheduler.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
