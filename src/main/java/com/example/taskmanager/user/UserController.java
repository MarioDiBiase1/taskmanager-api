package com.example.taskmanager.user;

import com.example.taskmanager.common.ApiResponse;
import com.example.taskmanager.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ApiResponse<UserDTO> create(@RequestBody User user) {

        User saved = userService.createUser(user);

        return ApiResponse.<UserDTO>builder()
                .success(true)
                .message("User created")
                .data(Mapper.toUserDTO(saved))
                .build();
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAllUsers()
                .stream()
                .map(Mapper::toUserDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return Mapper.toUserDTO(userService.getUserById(id));
    }

    @GetMapping("/debug")
    public List<User> debugAllUsers() {
        return userService.getAllUsers();
    }

}