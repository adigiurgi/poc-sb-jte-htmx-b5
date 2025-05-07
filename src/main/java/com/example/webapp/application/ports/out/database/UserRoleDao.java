package com.example.webapp.application.ports.out.database;

import com.example.webapp.application.domain.models.UserRole;

public interface UserRoleDao {
    /**
     * Creates a new user role in the database
     * @param userRoleCreateDto Role data to save
     * @return ID of the saved role
     */
    Long saveUserRole(UserRole userRole);
}
