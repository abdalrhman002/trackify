package com.mujahid.trackify.controllers;

import com.mujahid.trackify.domain.dto.TaskListDto;
import com.mujahid.trackify.domain.entities.TaskList;
import com.mujahid.trackify.mappers.TaskListMapper;
import com.mujahid.trackify.services.TaskListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;

    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper){
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> getTaskLists(){
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskListDto creatTaskList(@RequestBody TaskListDto taskListDto){
        TaskList creatTaskList = taskListService.creatTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(creatTaskList);
    }

    @GetMapping(path = "/{task_list_id}")
    public TaskListDto getTaskList(@PathVariable("task_list_id")UUID taskListId){
        return taskListMapper.toDto(
                taskListService.getTaskList(taskListId));
    }

}
