package com.jexpression.taskup.service;
import com.jexpression.taskup.model.Task;
import com.jexpression.taskup.model.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
    List<Task> getTasksByStatus(TaskStatus status);
}
