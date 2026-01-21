package com.mujahid.trackify.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "due-date")
    private LocalDateTime dueDate;

    @Column(name = "creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "update", nullable = false)
    private LocalDateTime lastUpdateDate;

    @Column(name = "priority", nullable = false)
    private TaskPriority taskPriority;

    @Column(name = "status", nullable = false)
    private TaskStatus taskStatus;

    public Task() {
    }

    public Task(UUID id, String title, String description, LocalDateTime dueDate, LocalDateTime creationDate, LocalDateTime lastUpdateDate, TaskPriority taskPriority, TaskStatus taskStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate) && Objects.equals(creationDate, task.creationDate) && Objects.equals(lastUpdateDate, task.lastUpdateDate) && taskPriority == task.taskPriority && taskStatus == task.taskStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, creationDate, lastUpdateDate, taskPriority, taskStatus);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", taskPriority=" + taskPriority +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
