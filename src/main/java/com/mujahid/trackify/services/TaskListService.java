package com.mujahid.trackify.services;

import com.mujahid.trackify.domain.entities.TaskList;

import java.util.List;
import java.util.UUID;

public interface TaskListService {
    List<TaskList> listTaskLists();
    TaskList creatTaskList(TaskList taskList);
    TaskList getTaskList(UUID id);
    TaskList updateTaskList(UUID id, TaskList taskList);
}
