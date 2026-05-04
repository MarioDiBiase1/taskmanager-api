package com.example.taskmanager.debug;

import com.example.taskmanager.project.ProjectRepository;
import com.example.taskmanager.task.TaskRepository;
import com.example.taskmanager.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debug")
@RequiredArgsConstructor
public class DebugController {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @DeleteMapping("/reset")
    public String resetDatabase() {

        // ordine corretto per evitare problemi di FK
        taskRepository.deleteAll();
        projectRepository.deleteAll();
        userRepository.deleteAll();

        return "Database resettato con successo 🚀";
    }
}