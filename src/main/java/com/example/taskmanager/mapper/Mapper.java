package com.example.taskmanager.mapper;

import com.example.taskmanager.project.Project;
import com.example.taskmanager.project.ProjectDTO;
import com.example.taskmanager.task.CreateTaskRequest;
import com.example.taskmanager.task.Task;
import com.example.taskmanager.task.TaskDTO;
import com.example.taskmanager.user.User;
import com.example.taskmanager.user.UserDTO;

import java.util.List;

public class Mapper {

    // =========================
    // USER
    // =========================
    public static UserDTO toUserDTO(User user) {
        if (user == null) return null;

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .projects(
                        user.getProjects() == null ? List.of() :
                                user.getProjects()
                                        .stream()
                                        .map(Mapper::toProjectDTO)
                                        .toList()
                )
                .build();
    }

    // =========================
    // PROJECT
    // =========================
    public static ProjectDTO toProjectDTO(Project project) {
        if (project == null) return null;

        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .tasks(
                        project.getTasks() == null ? List.of() :
                                project.getTasks()
                                        .stream()
                                        .map(Mapper::toTaskDTO)
                                        .toList()
                )
                .build();
    }

    // =========================
    // TASK
    // =========================
    public static TaskDTO toTaskDTO(Task task) {
        if (task == null) return null;

        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .build();
    }



}