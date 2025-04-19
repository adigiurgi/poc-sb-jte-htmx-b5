package com.example.webapp.application.domain.service.web;

import com.example.webapp.application.ports.in.web.UserActiveProfileApi;
import com.example.webapp.application.ports.out.database.UserActiveProfileDao;

public class UserActiveProfileApiImplementation implements UserActiveProfileApi {
    // This class implements the UserActiveProfileApi interface and provides the necessary methods to interact with user active profiles.
    // It uses the UserActiveProfileDao interface to perform database operations.

    private final UserActiveProfileDao userActiveProfileDao;

    public UserActiveProfileApiImplementation(UserActiveProfileDao userActiveProfileDao) {
        this.userActiveProfileDao = userActiveProfileDao;
    }

    // Implement methods from UserActiveProfileApi interface here
}
