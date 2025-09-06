package com.example.synergySphere.service;

import com.example.synergySphere.model.Project;
import com.example.synergySphere.repository.ProjectRepository;
import com.example.synergySphere.dto.ProjectRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(ProjectRequestDTO request) {
        Project project = new Project();
        project.setName(request.getName());
        project.setProjectDescription(request.getProjectDescription());
        project.setManagerId(request.getManagerId());
        project.setPriority(request.getPriority());
        project.setDeadline(request.getDeadline());

        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }
}
