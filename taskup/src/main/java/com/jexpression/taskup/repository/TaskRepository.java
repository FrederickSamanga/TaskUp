package com.jexpression.taskup.repository;
import com.jexpression.taskup.model.Task;
import com.jexpression.taskup.model.TaskStatus;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskStatus(@Nullable TaskStatus status);

    @Override
    @NonNull
    Page<Task> findAll(@Nonnull Pageable pageable);
}


