package com.mujahid.trackify.services;

import com.mujahid.trackify.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
    Task creatTask(UUID taskListId, Task task);
}
