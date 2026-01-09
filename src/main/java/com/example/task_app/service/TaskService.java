package com.example.task_app.service;

import java.util.List;
import java.util.UUID;

import com.example.task_app.domain.CreateTaskRequest;
import com.example.task_app.domain.UpdateTaskRequest;
import com.example.task_app.domain.entity.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskID,UpdateTaskRequest request);

}
