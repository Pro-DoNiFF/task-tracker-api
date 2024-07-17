package com.doniff.tasktrackerapi.store.api.controllers.helpers;

import com.doniff.tasktrackerapi.store.api.exceptions.NotFoundException;
import com.doniff.tasktrackerapi.store.entities.ProjectEntity;
import com.doniff.tasktrackerapi.store.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Transactional
public class ControllerHelper {

    private final ProjectRepository projectRepository;

    public ProjectEntity getProjectOrThrowException(Long projectId) throws NotFoundException {

        return projectRepository
                .findById(projectId)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Project with \"%s\" doesn't exist.",projectId))
                );
    }
}