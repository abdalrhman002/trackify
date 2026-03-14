package com.mujahid.trackify.controllers;

import com.mujahid.trackify.domain.dto.TaskDto;
import com.mujahid.trackify.domain.dto.TaskListDto;
import com.mujahid.trackify.domain.entities.Task;
import com.mujahid.trackify.exceptions.ResourceNotFoundException;
import com.mujahid.trackify.mappers.TaskMapper;
import com.mujahid.trackify.services.TaskService;
import com.mujahid.trackify.services.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @PostMapping
    public TaskDto creatTask(@PathVariable("task_list_id")UUID taskListId,
                             @RequestBody TaskDto taskDto){
        return taskMapper.toDto(
                taskService.creatTask(
                        taskListId, taskMapper.formDto(taskDto)));
    }

    @GetMapping(path = "/{task_id}")
    public TaskDto getTask(
            @PathVariable("task_list_id") UUID taskListId,
            @PathVariable("task_id") UUID taskId
            ){

        return taskMapper.toDto(
                taskService.getTask(taskListId, taskId)
        );
    }
    @PutMapping(path = "/{task_id}")
    public TaskDto updateTask(
            @PathVariable("task_list_id") UUID taskListId,
            @PathVariable("task_id") UUID taskId,
            @RequestBody TaskDto taskDto
    ){
        return taskMapper.toDto(
                taskService.updateTask(taskListId, taskId, taskMapper.formDto(taskDto))
        );
    }
    @DeleteMapping(path ="/{task_id}")
    public void deleteTask(
            @PathVariable("task_list_id") UUID taskListId,
            @PathVariable("task_id") UUID taskId
    ){
        taskService.deleteTask(taskListId, taskId);
    }
}
