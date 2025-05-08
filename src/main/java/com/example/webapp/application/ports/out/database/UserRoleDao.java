package com.example.webapp.application.ports.out.database;

import com.example.webapp.application.domain.models.UserRole;

public interface UserRoleDao {
    /**
     * Creates a new user role in the database
     * @param userRoleCreateDto Role data to save
     * @return ID of the saved role
     */
    Long saveUserRole(UserRole userRole);
    
    /**
     * Checks if a user has a specific role
     * @param idUser The user ID
     * @param roleName The role name to check
     * @return true if the user has the role, false otherwise
     */
    boolean hasRole(Long idUser, String roleName);
}
