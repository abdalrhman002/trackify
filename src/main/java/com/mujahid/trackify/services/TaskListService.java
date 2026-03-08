package com.mujahid.trackify.services;

import com.mujahid.trackify.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();

    TaskList creatTaskList(TaskList taskList);
}
