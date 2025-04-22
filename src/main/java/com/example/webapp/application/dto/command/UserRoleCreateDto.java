package com.example.webapp.application.dto.command;

public record UserRoleCreateDto(
        Long id,
        Long idUser,
        String roleName,
        String roleDescription
) {
}
