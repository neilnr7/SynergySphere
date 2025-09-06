package com.example.synergySphere.repository;

import com.example.synergySphere.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Additional query methods if needed
}
