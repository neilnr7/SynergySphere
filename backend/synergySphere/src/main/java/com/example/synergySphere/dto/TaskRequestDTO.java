package com.example.synergySphere.dto;

import com.example.synergySphere.model.TaskPriority;
import com.example.synergySphere.model.TaskStatus;

import java.time.LocalDate;

public class TaskRequestDTO {

    private Long projectId;
    private String title;
    private String taskDescription;
    private Long assigneeId;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDate deadline;

    // Getters & Setters
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getTaskDescription() { return taskDescription; }
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }

    public Long getAssigneeId() { return assigneeId; }
    public void setAssigneeId(Long assigneeId) { this.assigneeId = assigneeId; }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }

    public TaskPriority getPriority() { return priority; }
    public void setPriority(TaskPriority priority) { this.priority = priority; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
}
