package com.example.task_app.mapper;

import com.example.task_app.domain.CreateTaskRequest;
import com.example.task_app.domain.dto.CreateTaskRequestDto;
import com.example.task_app.domain.dto.TaskDto;
import com.example.task_app.domain.entity.Task;

public interface TaskMapper{

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
