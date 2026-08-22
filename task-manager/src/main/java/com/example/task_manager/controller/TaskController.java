package com.example.task_manager.controller;

import com.example.task_manager.domain.Task;
import com.example.task_manager.dto.TaskCreateDTO;
import com.example.task_manager.dto.TaskUpdateDTO;
import com.example.task_manager.enums.TaskStatus;
import com.example.task_manager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskCreateDTO dto) {
        Task createdTask = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskUpdateDTO dto) {

        Task updatedTask = taskService.updateTask(id, dto);
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping(params = {"status", "!title"})
    public ResponseEntity<List<Task>> findTaskByStatus(@RequestParam TaskStatus status) {
        List<Task> tasks = taskService.findTaskByStatus(status);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(params = {"status", "title"})
    public ResponseEntity<List<Task>> findTaskByStatusAndTitle(@RequestParam TaskStatus status, @RequestParam String title) {
        List<Task> tasks = taskService.findTaskByStatusAndTitle(status, title);
        return ResponseEntity.ok(tasks);
    }
}
