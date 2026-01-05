package com.example.task_app.domain;

import com.example.task_app.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
     String title,
    String description,
    LocalDate dueDate,
    TaskPriority priority
){

}
