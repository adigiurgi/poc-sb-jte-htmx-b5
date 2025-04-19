package com.example.webapp.application.dto.query;

public record UserActiveProfileDto(
        Long id,
        Long idUser,
        String username,
        Long idProfile,
        String profileName
) {
}
