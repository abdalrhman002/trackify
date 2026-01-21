package com.mujahid.trackify.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "task-lists")
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID uuid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "update", nullable = false)
    private LocalDateTime lastUpdateDate;

}
