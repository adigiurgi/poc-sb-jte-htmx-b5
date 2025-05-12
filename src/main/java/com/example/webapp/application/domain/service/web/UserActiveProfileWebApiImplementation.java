package com.example.webapp.application.domain.service.web;

import com.example.webapp.application.ports.in.web.UserActiveProfileWebApi;
import com.example.webapp.application.ports.out.database.UserActiveProfileDao;

public class UserActiveProfileWebApiImplementation implements UserActiveProfileWebApi {
    // This class implements the UserActiveProfileApi interface and provides the necessary methods to interact with user active profiles.
    // It uses the UserActiveProfileDao interface to perform database operations.

    private final UserActiveProfileDao userActiveProfileDao;

    public UserActiveProfileWebApiImplementation(UserActiveProfileDao userActiveProfileDao) {
        this.userActiveProfileDao = userActiveProfileDao;
    }

    @Override
    public void setNewActiveProfile(Long idProfile) {
        //TODO
        //Optional<UserActiveProfile> userActiveProfile = userActiveProfileDao.
    }

    // Implement methods from UserActiveProfileApi interface here
}
