package com.example.webapp.application.domain.service.web;

import com.example.webapp.application.domain.models.UserProfile;
import com.example.webapp.application.ports.in.web.UserProfileWebApi;
import com.example.webapp.application.ports.out.database.UserProfileDao;

import java.util.List;

public class UserProfileWebApiImplementation implements UserProfileWebApi {

    private final UserProfileDao userProfileDao;

    public UserProfileWebApiImplementation(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    @Override
    public List<UserProfile> showUserProfiles(Long idUser) {
        return userProfileDao.findUserProfiles(idUser);
    }
}
