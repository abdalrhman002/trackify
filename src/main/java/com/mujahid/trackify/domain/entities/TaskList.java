package com.mujahid.trackify.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "task-lists")
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "taskList", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Task> tasks;

    @Column(name = "creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "update", nullable = false)
    private LocalDateTime lastUpdateDate;

    public TaskList() {
    }

    public TaskList(UUID id, String title, String description, List<Task> tasks, LocalDateTime creationDate, LocalDateTime lastUpdateDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tasks = tasks;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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

    public Integer getClosedTasksCount(){
        return tasks == null
                ? 0
                : Math.toIntExact(
                tasks.stream()
                        .filter(task -> task.getTaskStatus() == TaskStatus.CLOSE)
                        .count());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(id, taskList.id) && Objects.equals(title, taskList.title) && Objects.equals(description, taskList.description) && Objects.equals(tasks, taskList.tasks) && Objects.equals(creationDate, taskList.creationDate) && Objects.equals(lastUpdateDate, taskList.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, tasks, creationDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "uuid=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
