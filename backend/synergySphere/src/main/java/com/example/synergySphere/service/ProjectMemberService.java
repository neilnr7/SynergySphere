package com.example.synergySphere.service;

import com.example.synergySphere.model.ProjectMember;
import com.example.synergySphere.dto.ProjectMemberRequestDTO;
import com.example.synergySphere.repository.ProjectMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectMemberService {

    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    public ProjectMember addMember(ProjectMemberRequestDTO request) {
        // Check if member already exists
        Optional<ProjectMember> existing = projectMemberRepository
                .findByProjectIdAndUserId(request.getProjectId(), request.getUserId());
        if (existing.isPresent()) {
            throw new RuntimeException("User already a member of this project");
        }

        ProjectMember member = new ProjectMember();
        member.setProjectId(request.getProjectId());
        member.setUserId(request.getUserId());
        member.setRole(request.getRole() != null ? request.getRole() : member.getRole());

        return projectMemberRepository.save(member);
    }

    public List<ProjectMember> getMembersByProject(Long projectId) {
        return projectMemberRepository.findByProjectId(projectId);
    }

    public void removeMember(Long projectMemId) {
        projectMemberRepository.deleteById(projectMemId);
    }
}
