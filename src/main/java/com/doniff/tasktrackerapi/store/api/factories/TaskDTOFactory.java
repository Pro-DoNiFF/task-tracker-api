package com.doniff.tasktrackerapi.store.api.factories;

import com.doniff.tasktrackerapi.store.api.dto.ProjectDTO;
import com.doniff.tasktrackerapi.store.entities.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDTOFactory
{
    public ProjectDTO makeProjectDTO(ProjectEntity projectEntity)
    {
        return ProjectDTO.builder()
                .id(projectEntity.getId())
                .name(projectEntity.getName())
                .createdAt(projectEntity.getCreatedAt())
                .updatedAt(projectEntity.getUpdatedAt())
                .build();
    }
}
