package com.doniff.tasktrackerapi.store.repositories;

import com.doniff.tasktrackerapi.store.entities.TaskStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStateRepository extends JpaRepository<TaskStateEntity, Long> {
}
