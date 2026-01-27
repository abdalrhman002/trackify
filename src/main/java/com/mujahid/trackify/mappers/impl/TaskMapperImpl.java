package com.mujahid.trackify.mappers.impl;

import com.mujahid.trackify.domain.dto.TaskDto;
import com.mujahid.trackify.domain.entities.Task;
import com.mujahid.trackify.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public Task formDto(TaskDto dto) {

        return new Task(
                dto.id(),
                dto.title(),
                dto.description(),
                dto.dueDate(),
                null,
                null,
                dto.priority(),
                dto.status(),
                null);

    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getTaskPriority(),
                task.getTaskStatus()
        );
    }
}
