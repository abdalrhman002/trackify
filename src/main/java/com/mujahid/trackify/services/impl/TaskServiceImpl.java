package com.mujahid.trackify.services.impl;

import com.mujahid.trackify.domain.entities.Task;
import com.mujahid.trackify.domain.entities.TaskList;
import com.mujahid.trackify.domain.entities.TaskPriority;
import com.mujahid.trackify.domain.entities.TaskStatus;
import com.mujahid.trackify.exceptions.ResourceNotFoundException;
import com.mujahid.trackify.repositories.TaskListRepository;
import com.mujahid.trackify.repositories.TaskRepository;
import com.mujahid.trackify.services.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
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

    @Transactional
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

    @Override
    public Task getTask(UUID taskListId, UUID taskId) {
        return taskRepository
                .findByTaskListIdAndId(taskListId, taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task with this id and task list id not found!"
                        ));
    }

    @Transactional
    @Override
    public Task updateTask(UUID taskListId, UUID taskId, Task updatedTask) {

        if(updatedTask.getId() == null){
            throw new IllegalArgumentException("Task must has an id!");
        }
        if (!Objects.equals(updatedTask.getId(), taskId)){
            throw new IllegalArgumentException("Id miss match, can not update task!");
        }
        if (updatedTask.getTitle() == null || updatedTask.getTitle().isBlank()){
            throw new IllegalArgumentException("Task must has a title!");
        }
        if(updatedTask.getTaskStatus() == null){
            throw new IllegalArgumentException("Task must has a valid status!");
        }
        if(updatedTask.getTaskPriority() == null){
            throw new IllegalArgumentException("Task must has a valid priority!");
        }

        Task taskToUpdate = taskRepository
                .findByTaskListIdAndId(taskListId, taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task with this id and task list id not found!"
                        ));

        taskToUpdate.setTitle(updatedTask.getTitle());
        taskToUpdate.setDescription(updatedTask.getDescription());
        taskToUpdate.setTaskStatus(updatedTask.getTaskStatus());
        taskToUpdate.setTaskPriority(updatedTask.getTaskPriority());
        taskToUpdate.setDueDate(updatedTask.getDueDate());
        taskToUpdate.setLastUpdateDate(LocalDateTime.now());

        return taskRepository.save(taskToUpdate);

    }

    @Transactional
    @Override
    public void deleteTask(UUID taskListId, UUID taskId) {
        taskRepository.deleteByTaskListIdAndId(taskListId, taskId);
    }
}
