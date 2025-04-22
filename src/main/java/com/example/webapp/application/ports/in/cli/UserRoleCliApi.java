package com.example.webapp.application.ports.in.cli;

import com.example.webapp.application.dto.command.UserRoleCreateDto;

public interface UserRoleCliApi {
    /**
     * Creates a new role for a user
     * @param userRoleCreateDto Data for creating the role
     * @return ID of the created role
     */
    Long createUserRole(UserRoleCreateDto userRoleCreateDto);
}
