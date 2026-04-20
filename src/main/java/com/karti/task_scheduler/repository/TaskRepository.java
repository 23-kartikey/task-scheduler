package com.karti.task_scheduler.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karti.task_scheduler.entity.Status;
import com.karti.task_scheduler.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
    public List<Task> findByReminderTimeBeforeAndStatusNot(LocalDateTime now, Status status);

}
