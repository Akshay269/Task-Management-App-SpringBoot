package com.example.task_app.mapper.impl;

import com.example.task_app.domain.CreateTaskRequest;
import com.example.task_app.domain.dto.CreateTaskRequestDto;
import com.example.task_app.domain.dto.TaskDto;
import com.example.task_app.domain.entity.Task;
import com.example.task_app.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
