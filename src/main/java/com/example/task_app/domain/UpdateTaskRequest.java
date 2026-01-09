package com.example.task_app.domain;

import java.time.LocalDate;

import com.example.task_app.domain.entity.TaskStatus;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        Tas
        TaskStatus status
        ) {

}
