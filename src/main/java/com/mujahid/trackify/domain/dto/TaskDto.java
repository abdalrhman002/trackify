package com.mujahid.trackify.domain.dto;

import com.mujahid.trackify.domain.entities.TaskPriority;
import com.mujahid.trackify.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
