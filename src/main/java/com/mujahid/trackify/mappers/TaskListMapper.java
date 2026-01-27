package com.mujahid.trackify.mappers;

import com.mujahid.trackify.domain.dto.TaskListDto;
import com.mujahid.trackify.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto dto);

    TaskListDto toDto(TaskList taskList);
}
