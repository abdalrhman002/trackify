package com.mujahid.trackify.services;

import com.mujahid.trackify.domain.entities.Task;
import com.mujahid.trackify.domain.entities.TaskPriority;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
    Task creatTask(UUID taskListId, Task task);
    Task getTask(UUID taskListId, UUID taskId);
    Task updateTask(UUID taskListId, UUID taskId, Task updatedTask);
    void deleteTask(UUID taskListId, UUID taskId);
}
