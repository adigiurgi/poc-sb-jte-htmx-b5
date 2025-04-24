package com.example.webapp.application.ports.out.database;

import com.example.webapp.application.domain.models.UserProfile;

import java.util.List;

public interface UserProfileDao {
    /**
     * Creates a new user profile in the database
     * @param userProfileCreateDto Profile data to save
     * @return ID of the saved profile
     */
    Long saveUserProfile(UserProfile userProfile);
    List<UserProfile> findAllUserProfiles(Long idUser);
}
