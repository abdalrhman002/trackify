package com.mujahid.trackify.controllers;

import com.mujahid.trackify.domain.dto.TaskDto;
import com.mujahid.trackify.mappers.TaskMapper;
import com.mujahid.trackify.services.TaskService;
import com.mujahid.trackify.services.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists/{task_list_id}/tasks")
public class TasksController {
    private final TaskMapper taskMapper;
    private final TaskService taskService;

    @Autowired
    public TasksController(TaskMapper taskMapper, TaskService taskService){
        this.taskMapper = taskMapper;
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id")UUID taskListId){
        return taskService.listTasks(taskListId)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }
}
