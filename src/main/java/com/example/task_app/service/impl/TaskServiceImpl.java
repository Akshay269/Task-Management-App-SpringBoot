package com.example.task_app.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.task_app.domain.CreateTaskRequest;
import com.example.task_app.domain.UpdateTaskRequest;
import com.example.task_app.domain.entity.Task;
import com.example.task_app.domain.entity.TaskStatus;
import com.example.task_app.exception.TaskNotFoundException;
import com.example.task_app.repository.TaskRepository;
import com.example.task_app.service.TaskService;

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

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC,"created"));

    }

    @Override
    public Task updateTask(UUID taskID, UpdateTaskRequest request) {
       Task task=taskRepository.findById(taskID)
       .orElseThrow(()->new TaskNotFoundException(taskID));

       task.setTitle(request.title());
       task.setDescription(request.description());
         task.setDueDate(request.dueDate());
         task.setStatus(request.status());
            task.setPriority(request.priority());
            task.setUpdated(Instant.now());





       return taskRepository.save(task);
    }

    


}
