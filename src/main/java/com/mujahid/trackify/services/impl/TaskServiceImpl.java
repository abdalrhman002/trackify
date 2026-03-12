package com.mujahid.trackify.services.impl;

import com.mujahid.trackify.domain.entities.Task;
import com.mujahid.trackify.domain.entities.TaskList;
import com.mujahid.trackify.domain.entities.TaskPriority;
import com.mujahid.trackify.domain.entities.TaskStatus;
import com.mujahid.trackify.repositories.TaskListRepository;
import com.mujahid.trackify.repositories.TaskRepository;
import com.mujahid.trackify.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository){
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task creatTask(UUID taskListId, Task task) {
        if (task.getId() != null){
            throw new  IllegalArgumentException("Task already has an id!");
        }
        if (task.getTitle() == null || task.getTitle().isBlank()){
            throw new  IllegalArgumentException("Task must has a title!");
        }

        TaskPriority taskPriority = Optional
                .ofNullable(task.getTaskPriority())
                .orElse(TaskPriority.MEDIUM);

        TaskStatus taskStatus = TaskStatus.OPEN;

        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(()-> new IllegalArgumentException("Provided task list id is invalid!"));

        LocalDateTime now =  LocalDateTime.now();

        Task taskToSave = new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                now,
                now,
                taskPriority,
                taskStatus,
                taskList
        );
        return taskRepository.save(taskToSave);

    }
}
