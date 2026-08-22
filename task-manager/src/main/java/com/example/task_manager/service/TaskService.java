package com.example.task_manager.service;

import com.example.task_manager.domain.Task;
import com.example.task_manager.dto.TaskCreateDTO;
import com.example.task_manager.dto.TaskUpdateDTO;
import com.example.task_manager.enums.TaskStatus;
import com.example.task_manager.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public Task createTask(TaskCreateDTO dto) {
        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());

        return taskRepository.save(task);
    }

    @Transactional
    public Task updateTask(Long id, TaskUpdateDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id: " + id));

        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());

        return taskRepository.save(task);
    }

    @Transactional
    public List<Task> findTaskByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    @Transactional
    public List<Task> findTaskByStatusAndTitle(TaskStatus status, String title) {
        //List<Task> tasks = taskRepository.findByStatusAndTitleContainingIgnoreCaseOrderByTitleAsc(status, title);
        //List<Task> tasks = taskRepository.searchByStatusAndTitleJpql(status, title);
        List<Task> tasks = taskRepository.searchByStatusAndTitleNative(status.name(), title);
        return tasks;
    }
}
