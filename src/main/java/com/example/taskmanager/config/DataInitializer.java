package com.example.taskmanager.config;

import com.example.taskmanager.user.Role;
import com.example.taskmanager.user.User;
import com.example.taskmanager.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        System.out.println("🔥 DATA INITIALIZER PARTITO");

        if (userRepository.findAll().stream()
                .anyMatch(u -> u.getUsername().equals("admin"))) {
            System.out.println("⚠️ ADMIN già esistente");
            return;
        }

        User admin = User.builder()
                .username("admin")
                .email("admin@email.com")
                .password(passwordEncoder.encode("1234"))
                .role(Role.ADMIN) // 🔥 IMPORTANTE
                .build();

        userRepository.save(admin);

        System.out.println("✅ ADMIN CREATO");
    }
}