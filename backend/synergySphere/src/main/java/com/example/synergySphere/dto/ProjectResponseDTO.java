package com.example.synergySphere.dto;


import com.example.synergySphere.model.TaskPriority;

import java.time.LocalDate;

public class ProjectResponseDTO {

    private Long projectId;
    private String name;
    private String projectDescription;
    private TaskPriority priority;
    private LocalDate deadline;
    private LocalDate createdAt;

    public ProjectResponseDTO(Long projectId, String name, String projectDescription,
                              TaskPriority priority, LocalDate deadline, LocalDate createdAt) {
        this.projectId = projectId;
        this.name = name;
        this.projectDescription = projectDescription;
        this.priority = priority;
        this.deadline = deadline;
        this.createdAt = createdAt;
    }

    // Getters (no setters to keep it immutable)
    public Long getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}

