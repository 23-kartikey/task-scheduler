package com.karti.task_scheduler.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karti.task_scheduler.entity.Status;
import com.karti.task_scheduler.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
    public List<Task> findByReminderTimeBeforeAndStatusNot(LocalDateTime now, Status status);

    public Optional<Task> findByIdAndStatusIs(Long id, Status status);

    public List<Task> findByRetryCountGreaterThanAndStatusNot(int count, Status status);
}
