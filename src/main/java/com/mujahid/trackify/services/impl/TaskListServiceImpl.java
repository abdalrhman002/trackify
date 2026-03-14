package com.mujahid.trackify.services.impl;

import com.mujahid.trackify.domain.entities.TaskList;
import com.mujahid.trackify.exceptions.ResourceNotFoundException;
import com.mujahid.trackify.repositories.TaskListRepository;
import com.mujahid.trackify.services.TaskListService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    @Autowired
    public TaskListServiceImpl(TaskListRepository taskListRepository){
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {

        return taskListRepository.findAll();
    }

    @Override
    public TaskList creatTaskList(TaskList taskList) {
        if(taskList.getId() != null){
            throw new IllegalArgumentException("Task list already has an ID!");
        }
        if(taskList.getTitle() == null || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("Task list title is a must!");
        }

        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }

    @Override
    public TaskList getTaskList(UUID id) {
        return taskListRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Task list dose not exist!"));
    }

    @Transactional
    @Override
    public TaskList updateTaskList(UUID id, TaskList taskList) {
        if (id == null){
            throw new IllegalArgumentException("Task list id is required!");
        }
        if (!Objects.equals(taskList.getId(), id)){
            throw new IllegalArgumentException("Id mismatch!, can not update");
        }
        TaskList currentTaskList = taskListRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task list dose not exist!"));

        currentTaskList.setTitle(taskList.getTitle());
        currentTaskList.setDescription(taskList.getDescription());
        currentTaskList.setLastUpdateDate(LocalDateTime.now());

        return taskListRepository.save(currentTaskList);
    }

    @Override
    public void deleteTaskList(UUID id) {

        taskListRepository.deleteById(id);
    }

}
