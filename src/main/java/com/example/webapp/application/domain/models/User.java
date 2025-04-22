package com.example.webapp.application.domain.models;

import java.time.LocalDateTime;

public record User(
        Long id,
        String username,
        String email,
        String firstName,
        String lastName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
