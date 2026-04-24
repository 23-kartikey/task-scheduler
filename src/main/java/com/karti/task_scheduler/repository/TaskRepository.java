package com.karti.task_scheduler.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karti.task_scheduler.entity.Status;
import com.karti.task_scheduler.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

    public List<Task> findByStatus(Status status);
    
    public List<Task> findByReminderTimeBeforeAndStatusIs(LocalDateTime now, Status status);

    public Optional<Task> findByIdAndStatusIs(Long id, Status status);

    public List<Task> findByRetryCountIsAndStatusIs(int count, Status status);

    public List<Task> findByReminderTimeBeforeAndStatusIsAndRetryCountLessThan(LocalDateTime now, Status status, int retryCount);

    public List<Task> findByReminderTimeBeforeAndStatusIsAndRetryCountGreaterThan(LocalDateTime now, Status status, int retryCount);

    public void deleteByStatus(Status status);
}
