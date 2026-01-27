package com.mujahid.trackify.mappers.impl;

import com.mujahid.trackify.domain.dto.TaskDto;
import com.mujahid.trackify.domain.dto.TaskListDto;
import com.mujahid.trackify.domain.entities.Task;
import com.mujahid.trackify.domain.entities.TaskList;
import com.mujahid.trackify.domain.entities.TaskStatus;
import com.mujahid.trackify.mappers.TaskListMapper;
import com.mujahid.trackify.mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    @Autowired
    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto dto) {

        List<Task> tasks = dto.tasks() == null
                ? List.of()
                : dto.tasks().stream()
                .map(taskMapper::formDto)
                .toList();

        return new TaskList(
                dto.id(),
                dto.title(),
                dto.description(),
                tasks,
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {

        List<Task> tasks = taskList.getTasks();

        List<TaskDto> taskDtos = tasks == null
                ? List.of()
                : tasks.stream()
                .map(taskMapper::toDto)
                .toList();


        int tasksCount = tasks == null ? 0 : tasks.size();



        return new  TaskListDto(
                taskList.getUuid(),
                taskList.getTitle(),
                taskList.getDescription(),
                taskDtos,
                tasksCount,
                taskList.getClosedTasksCount()

        );
    }
}
