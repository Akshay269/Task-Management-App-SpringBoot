package com.example.task_app.service;

import com.example.task_app.domain.CreateTaskRequest;
import com.example.task_app.domain.entity.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);

}
