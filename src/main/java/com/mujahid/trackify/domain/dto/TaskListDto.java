package com.mujahid.trackify.domain.dto;

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
