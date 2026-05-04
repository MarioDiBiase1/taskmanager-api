package com.example.taskmanager.project;

import com.example.taskmanager.common.ApiResponse;
import com.example.taskmanager.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getAll() {
        return projectService.getAllProjects()
                .stream()
                .map(Mapper::toProjectDTO)
                .toList();
    }

    @PostMapping("/user/{userId}")
    public ApiResponse<ProjectDTO> createForUser(
            @PathVariable Long userId,
            @RequestBody CreateProjectRequest request
    ) {

        ProjectDTO project = projectService.createProject(userId, request);

        return ApiResponse.<ProjectDTO>builder()
                .success(true)
                .message("Project created successfully")
                .data(project)
                .build();
    }

    @GetMapping("/{id}")
    public ProjectDTO getById(@PathVariable Long id) {
        return Mapper.toProjectDTO(projectService.getProjectById(id));
    }
}