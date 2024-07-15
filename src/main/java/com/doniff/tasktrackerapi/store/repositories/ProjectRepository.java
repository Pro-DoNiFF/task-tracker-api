package com.doniff.tasktrackerapi.store.repositories;

import com.doniff.tasktrackerapi.store.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
