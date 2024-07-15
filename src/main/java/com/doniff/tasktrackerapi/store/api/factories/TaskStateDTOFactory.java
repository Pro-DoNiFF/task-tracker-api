package com.doniff.tasktrackerapi.store.api.factories;

import com.doniff.tasktrackerapi.store.api.dto.TaskStateDTO;
import com.doniff.tasktrackerapi.store.entities.TaskStateEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskStateDTOFactory
{
    public TaskStateDTO makeTaskStateDTO(TaskStateEntity taskStateEntity)
    {
        return TaskStateDTO.builder()
                .id(taskStateEntity.getId())
                .name(taskStateEntity.getName())
                .ordinal(taskStateEntity.getOrdinal())
                .createdAt(taskStateEntity.getCreatedAt())
                .updatedAt(taskStateEntity.getUpdatedAt())
                .build();
    }
}
