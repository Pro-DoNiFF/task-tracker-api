package com.doniff.tasktrackerapi.store.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    @JsonProperty("created_at")
    private Instant createdAt;

    @NonNull
    @JsonProperty("updated_at")
    private Instant updatedAt;
}
