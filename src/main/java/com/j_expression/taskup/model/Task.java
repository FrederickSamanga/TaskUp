package com.j_expression.taskup.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Task {
    
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private LocalDate dueDate;

    @Enumerated(EnumType.STRING);
    private TaskStatus taskStatus;

    
}
