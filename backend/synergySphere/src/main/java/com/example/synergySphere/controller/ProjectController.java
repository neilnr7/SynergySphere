package com.example.synergySphere.controller;

import com.example.synergySphere.dto.ProjectRequestDTO;
import com.example.synergySphere.dto.ProjectResponseDTO;
import com.example.synergySphere.model.Project;
import com.example.synergySphere.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ProjectResponseDTO createProject(@RequestBody ProjectRequestDTO request) {
        Project project = projectService.createProject(request);
        return new ProjectResponseDTO(
                project.getProjectId(),
                project.getName(),
                project.getProjectDescription(),
                project.getPriority(),
                project.getDeadline(),
                project.getCreatedAt()
        );
    }

    @GetMapping
    public List<ProjectResponseDTO> getAllProjects() {
        return projectService.getAllProjects().stream()
                .map(project -> new ProjectResponseDTO(
                        project.getProjectId(),
                        project.getName(),
                        project.getProjectDescription(),
                        project.getPriority(),
                        project.getDeadline(),
                        project.getCreatedAt()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public ProjectResponseDTO getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        return new ProjectResponseDTO(
                project.getProjectId(),
                project.getName(),
                project.getProjectDescription(),
                project.getPriority(),
                project.getDeadline(),
                project.getCreatedAt()
        );
    }
}
