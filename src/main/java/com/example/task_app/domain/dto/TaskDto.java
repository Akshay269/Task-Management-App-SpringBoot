package com.example.task_app.domain.dto;

import com.example.task_app.domain.entity.TaskPriority;
import com.example.task_app.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
