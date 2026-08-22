package com.example.task_manager.dto;

import com.example.task_manager.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskUpdateDTO(
        @NotBlank String title,
        String description,
        @NotNull TaskStatus status
) {}
