package com.doniff.tasktrackerapi.store.api.factories;

import com.doniff.tasktrackerapi.store.api.dto.ProjectDTO;
import com.doniff.tasktrackerapi.store.api.dto.TaskDTO;
import com.doniff.tasktrackerapi.store.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDTOFactory
{
    public TaskDTO makeProjectDTO(TaskEntity entity)
    {
        return TaskDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
