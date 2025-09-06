package com.example.synergySphere.controller;

import com.example.synergySphere.dto.ProjectMemberRequestDTO;
import com.example.synergySphere.model.ProjectMember;
import com.example.synergySphere.service.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project-members")
public class ProjectMemberController {

    @Autowired
    private ProjectMemberService projectMemberService;

    @PostMapping
    public ProjectMember addMember(@RequestBody ProjectMemberRequestDTO request) {
        return projectMemberService.addMember(request);
    }

    @GetMapping("/project/{projectId}")
    public List<ProjectMember> getMembersByProject(@PathVariable Long projectId) {
        return projectMemberService.getMembersByProject(projectId);
    }

    @DeleteMapping("/{id}")
    public String removeMember(@PathVariable Long id) {
        projectMemberService.removeMember(id);
        return "Member removed successfully";
    }
}
