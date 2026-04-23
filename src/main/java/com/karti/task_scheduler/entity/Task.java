package com.karti.task_scheduler.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
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
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(sequenceName="tasks_seq",
                        name="task_seq",
                        allocationSize=2
    )
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column(length=1000)
    private String description;

    @Column(nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @Column(nullable=false)
    private LocalDateTime reminderTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Status status;

    private LocalDateTime lastAttemptTime;

    @Column(nullable=false)
    private Integer retryCount = 0 ;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();

        if(this.status==null) status=Status.PENDING;
        if(this.retryCount==null) retryCount=0;
    }

}
