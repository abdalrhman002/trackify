package com.mujahid.trackify.services;

import com.mujahid.trackify.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
    Task creatTask(UUID taskListId, Task task);
    Task getTask(UUID taskListId, UUID taskId);
    Task updateTask(UUID taskListId, UUID taskId, Task updatedTask);
    void deleteTask(UUID taskListId, UUID taskId);
}
