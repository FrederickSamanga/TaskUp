package com.jexpression.taskup.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import jakarta.validation.constraints.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, message = "Title cannot exceed 100 characters")
    @NotNull(message = "Title cannot be null")
    private String title;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @FutureOrPresent(message = "Due date must be today or in the future")
    @Past(message = "Due date cannot be in the future")
    private LocalDate dueDate;


    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    public Task() {
    }

    public Task(String title, String description, LocalDate dueDate, TaskStatus taskStatus) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.taskStatus = taskStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
