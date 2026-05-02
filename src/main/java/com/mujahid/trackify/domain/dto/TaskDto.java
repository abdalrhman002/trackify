package com.mujahid.trackify.domain.dto;

import com.mujahid.trackify.domain.enums.TaskPriority;
import com.mujahid.trackify.domain.enums.TaskStatus;

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
