package com.example.webapp.application.dto.command;

public record UserAppCreateDto(
        String username,
        String email,
        String firstName,
        String lastName
) {
}
