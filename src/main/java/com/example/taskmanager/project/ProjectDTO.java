package com.example.taskmanager.project;

import com.example.taskmanager.task.Task;
import com.example.taskmanager.task.TaskDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO {

    private Long id;
    private String name;
    private String description;

    private List<TaskDTO> tasks;
}