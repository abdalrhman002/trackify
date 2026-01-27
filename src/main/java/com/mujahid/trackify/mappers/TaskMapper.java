package com.mujahid.trackify.mappers;

import com.mujahid.trackify.domain.dto.TaskDto;
import com.mujahid.trackify.domain.entities.Task;

public interface TaskMapper {

    Task formDto(TaskDto dto);

    TaskDto toDto(Task task);

}
