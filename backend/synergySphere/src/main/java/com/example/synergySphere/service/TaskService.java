package com.example.synergySphere.service;

import com.example.synergySphere.model.Task;
import com.example.synergySphere.dto.TaskRequestDTO;
import com.example.synergySphere.model.TaskPriority;
import com.example.synergySphere.model.TaskStatus;
import com.example.synergySphere.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskRequestDTO request) {
        Task task = new Task();
        task.setProjectId(request.getProjectId());
        task.setTitle(request.getTitle());
        task.setTaskDescription(request.getTaskDescription());
        task.setAssigneeId(request.getAssigneeId());
        task.setStatus(request.getStatus() != null ? request.getStatus() : TaskStatus.ToDo);
        task.setPriority(request.getPriority() != null ? request.getPriority() : TaskPriority.Medium);
        task.setDeadline(request.getDeadline());
        task.setCreatedAt(LocalDate.now());
        task.setUpdatedAt(LocalDate.now());

        return taskRepository.save(task);
    }

    public List<Task> getTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public Optional<Task> getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public Task updateTask(Long taskId, TaskRequestDTO request) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (request.getTitle() != null) task.setTitle(request.getTitle());
        if (request.getTaskDescription() != null) task.setTaskDescription(request.getTaskDescription());
        if (request.getAssigneeId() != null) task.setAssigneeId(request.getAssigneeId());
        if (request.getStatus() != null) task.setStatus(request.getStatus());
        if (request.getPriority() != null) task.setPriority(request.getPriority());
        if (request.getDeadline() != null) task.setDeadline(request.getDeadline());

        task.setUpdatedAt(LocalDate.now());
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
