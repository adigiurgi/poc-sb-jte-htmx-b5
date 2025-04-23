package com.example.webapp.application.ports.out.database;

import com.example.webapp.application.dto.command.UserRoleCreateDto;

public interface UserRoleDao {
    /**
     * Creates a new user role in the database
     * @param userRoleCreateDto Role data to save
     * @return ID of the saved role
     */
    Long saveUserRole(UserRoleCreateDto userRoleCreateDto);
}
