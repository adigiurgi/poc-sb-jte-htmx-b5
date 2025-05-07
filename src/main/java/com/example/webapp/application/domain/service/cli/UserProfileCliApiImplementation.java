package com.example.webapp.application.domain.service.cli;

import com.example.webapp.application.domain.models.UserProfile;
import com.example.webapp.application.dto.command.UserProfileCreateDto;
import com.example.webapp.application.ports.in.cli.UserProfileCliApi;
import com.example.webapp.application.ports.out.database.UserProfileDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserProfileCliApiImplementation implements UserProfileCliApi {
    private final UserProfileDao userProfileDao;

    public UserProfileCliApiImplementation(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    @Override
    public Long createUserProfile(UserProfileCreateDto userProfileCreateDto) {
        log.info("Creating new profile for user ID: {} with name: {}", 
                userProfileCreateDto.idUser(), userProfileCreateDto.profileName());
        UserProfile userProfile = UserProfile.create(userProfileCreateDto.idUser(),
                userProfileCreateDto.profileName());
        Long profileId = userProfileDao.saveUserProfile(userProfile);
        log.info("Profile created successfully with ID: {}", profileId);
        
        return profileId;
    }
}
