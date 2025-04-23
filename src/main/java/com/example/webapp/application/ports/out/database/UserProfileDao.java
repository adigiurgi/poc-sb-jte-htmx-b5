package com.example.webapp.application.ports.out.database;

import com.example.webapp.application.dto.command.UserProfileCreateDto;

public interface UserProfileDao {
    /**
     * Creates a new user profile in the database
     * @param userProfileCreateDto Profile data to save
     * @return ID of the saved profile
     */
    Long saveUserProfile(UserProfileCreateDto userProfileCreateDto);
}
