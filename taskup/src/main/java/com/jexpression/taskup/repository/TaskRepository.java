package com.jexpression.taskup.repository;
import com.jexpression.taskup.model.Task;
import com.jexpression.taskup.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskStatus(TaskStatus status);
    // Custom query methods
}

