package com.karti.task_scheduler.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task{
    
    private long id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime reminderTime;

    private Status status;

    private LocalDateTime lastAttemptTime;

    private Integer retryCount;

    

}
