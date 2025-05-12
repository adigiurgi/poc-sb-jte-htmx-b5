package com.example.webapp.application.domain.service.web;

import com.example.webapp.application.domain.models.UserProfile;
import com.example.webapp.application.dto.query.UserProfileDto;
import com.example.webapp.application.ports.in.web.UserProfileWebApi;
import com.example.webapp.application.ports.out.database.UserProfileDao;

import java.util.List;

public class UserProfileWebApiImplementation implements UserProfileWebApi {

    private final UserProfileDao userProfileDao;

    public UserProfileWebApiImplementation(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    @Override
    public List<UserProfileDto> showUserProfiles(Long idUser, Long idProfile) {
        return userProfileDao.findUserProfiles(idUser).stream()
                .map(userProfile -> new UserProfileDto(
                        userProfile.getId(),
                        userProfile.getIdUser(),
                        userProfile.getProfileName()))
                .filter(userProfileDto -> !userProfileDto.id().equals(idProfile))
                .toList();
    }
}
