package com.doniff.tasktrackerapi.store.api.factories;

import com.doniff.tasktrackerapi.store.api.dto.ProjectDTO;
import com.doniff.tasktrackerapi.store.entities.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectDTOFactory {

    public static ProjectDTO makeProjectDTO(ProjectEntity entity)
    {
        return ProjectDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
