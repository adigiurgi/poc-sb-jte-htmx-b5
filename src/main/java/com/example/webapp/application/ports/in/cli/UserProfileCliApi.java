package com.example.webapp.application.ports.in.cli;

import com.example.webapp.application.dto.command.UserProfileCreateDto;

public interface UserProfileCliApi {
    /**
     * Creates a new profile for a user
     * @param userProfileCreateDto Data for creating the profile
     * @return ID of the created profile
     */
    Long createUserProfile(UserProfileCreateDto userProfileCreateDto);
}
