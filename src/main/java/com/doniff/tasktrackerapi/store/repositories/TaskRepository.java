package com.doniff.tasktrackerapi.store.repositories;

import com.doniff.tasktrackerapi.store.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>  {
}
