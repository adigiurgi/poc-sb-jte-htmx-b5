package com.example.webapp.application.ports.out.database.users;

import com.example.webapp.application.domain.models.users.UserRole;

import java.util.List;

public interface UserRoleDao {
    /**
     * Creates a new user role in the database
     * @param userRole Role data to save
     * @return ID of the saved role
     */
    Long saveUserRole(UserRole userRole);

    /**
     * Rolurile/Modulele la care utilizatorul conectat are acces
     * @param idUser Id-ul utilizatorului conectat
     * @return returneaza lista de roluri a utilizatorului conectat
     */
    List<UserRole> findRolesByIdUser(Long idUser);
}
