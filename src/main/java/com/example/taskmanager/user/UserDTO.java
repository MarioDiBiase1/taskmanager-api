package com.example.taskmanager.user;

import com.example.taskmanager.project.Project;
import com.example.taskmanager.project.ProjectDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String email;

    private List<ProjectDTO> projects;
}