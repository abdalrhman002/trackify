package com.mujahid.trackify.domain.dto;

import com.mujahid.trackify.domain.entities.Task;
import com.mujahid.trackify.domain.entities.TaskPriority;
import com.mujahid.trackify.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record TaskListDto(
        UUID id,
        String title,
        String description,
        List<TaskDto> tasks,
        Integer numOfTasks,
        Integer numOfTasksDone
) {
}
