package com.example.webapp.application.ports.out.database;

import com.example.webapp.application.domain.models.UserApp;

public interface UserAppDao {
    /**
     * Creates a new user in the database
     * @param userApp User model to save
     * @return ID of the saved user
     */
    Long saveUser(UserApp userApp);
}
