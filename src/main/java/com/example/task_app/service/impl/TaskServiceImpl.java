package com.example.task_app.service.impl;

import com.example.task_app.domain.CreateTaskRequest;
import com.example.task_app.domain.entity.Task;
import com.example.task_app.domain.entity.TaskStatus;
import com.example.task_app.repository.TaskRepository;
import com.example.task_app.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }



    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now=Instant.now();

        Task task=new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );

        return taskRepository.save(task);
    }
}
