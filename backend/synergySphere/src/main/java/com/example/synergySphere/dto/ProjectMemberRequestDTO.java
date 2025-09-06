package com.example.synergySphere.dto;

import com.example.synergySphere.model.UserRole;

public class ProjectMemberRequestDTO {

    private Long projectId;
    private Long userId;
    private UserRole role;

    // Getters & Setters
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }
}
