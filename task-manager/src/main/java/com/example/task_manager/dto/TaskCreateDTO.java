package com.example.task_manager.dto;

import com.example.task_manager.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskCreateDTO(
        @NotBlank(message = "O título é obrigatório")
        String title,

        String description,

        @NotNull(message = "O status é obrigatório")
        TaskStatus status
) {}