package com.example.taskmanager.common;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorResponse {

    private boolean success;
    private String message;
    private int status;
    private LocalDateTime timestamp;
}