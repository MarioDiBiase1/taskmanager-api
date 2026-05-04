package com.example.taskmanager.task;

import com.example.taskmanager.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/project/{projectId}")
    public TaskDTO createTask(
            @PathVariable Long projectId,
            @RequestBody CreateTaskRequest request
    ) {
        return Mapper.toTaskDTO(
                taskService.createTask(projectId, request)
        );
    }

    @GetMapping
    public List<TaskDTO> getAll() {
        return taskService.getAllTasks()
                .stream()
                .map(Mapper::toTaskDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public TaskDTO getById(@PathVariable Long id) {
        return Mapper.toTaskDTO(taskService.getById(id));
    }
}