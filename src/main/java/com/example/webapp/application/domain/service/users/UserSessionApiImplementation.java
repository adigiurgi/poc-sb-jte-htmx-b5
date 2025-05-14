package com.example.webapp.application.domain.service.users;

import com.example.webapp.application.dto.query.UserProfileDto;
import com.example.webapp.application.ports.in.users.UserSessionApi;
import com.example.webapp.application.ports.out.database.users.UserProfileDao;

import java.util.List;

public class UserSessionApiImplementation implements UserSessionApi {

    private final UserProfileDao userProfileDao;

    public UserSessionApiImplementation(UserProfileDao userProfileDao) {
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

    @Override
    public void setNewActiveProfile(Long idProfile) {

    }
}
