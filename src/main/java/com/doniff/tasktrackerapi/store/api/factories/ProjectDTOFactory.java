package com.doniff.tasktrackerapi.store.api.factories;

import com.doniff.tasktrackerapi.store.api.dto.TaskDTO;
import com.doniff.tasktrackerapi.store.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectDTOFactory {

    public TaskDTO makeProjectDTO(TaskEntity taskEntity)
    {
        return TaskDTO.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .description(taskEntity.getDescription())
                .createdAt(taskEntity.getCreatedAt())
                .updatedAt(taskEntity.getUpdatedAt())
                .build();
    }
}
