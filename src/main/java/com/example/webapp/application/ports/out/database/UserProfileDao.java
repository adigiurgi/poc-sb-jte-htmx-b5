package com.example.webapp.application.ports.out.database;

import com.example.webapp.application.domain.models.UserProfile;

import java.util.List;

public interface UserProfileDao {
    /**
     * Creates a new user profile in the database
     * @param userProfile Profile data to save
     * @return ID of the saved profile
     */
    Long saveUserProfile(UserProfile userProfile);
    /**
     * Retrieves a list of user profiles associated with a specific user ID
     * @param idUser ID of the user whose profiles are to be retrieved
     * @return List of user profiles
     */
    List<UserProfile> findUserProfiles(Long idUser);
}
