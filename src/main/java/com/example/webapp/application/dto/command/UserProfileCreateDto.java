package com.example.webapp.application.dto.command;

public record UserProfileCreateDto(
        Long id,
        Long idUser,
        String profileName
) {
}
