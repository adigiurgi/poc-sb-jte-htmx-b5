package com.example.webapp.application.dto.command;

public record UserAppCreateDto(
        Long id,
        String username,
        String firstName,
        String lastName
) {

}
