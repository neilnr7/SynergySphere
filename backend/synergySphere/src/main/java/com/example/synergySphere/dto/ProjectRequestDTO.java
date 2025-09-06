package com.example.synergySphere.dto;

import com.example.synergySphere.model.TaskPriority;
import java.time.LocalDate;

public class ProjectRequestDTO {
    private String name;
    private String projectDescription;
    private Long managerId;
    private TaskPriority priority;
    private LocalDate deadline;

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getProjectDescription() { return projectDescription; }
    public void setProjectDescription(String projectDescription) { this.projectDescription = projectDescription; }

    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }

    public TaskPriority getPriority() { return priority; }
    public void setPriority(TaskPriority priority) { this.priority = priority; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
}
