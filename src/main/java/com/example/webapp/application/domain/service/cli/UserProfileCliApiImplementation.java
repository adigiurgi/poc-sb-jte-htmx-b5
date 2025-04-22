package com.example.webapp.application.domain.service.cli;

import com.example.webapp.application.ports.in.cli.UserProfileCliApi;
import com.example.webapp.application.ports.out.database.UserProfileDao;

public class UserProfileCliApiImplementation implements UserProfileCliApi {
    // This class implements the UserProfileApi interface and provides the necessary methods to interact with user profile data.
    // It uses the UserProfileDao interface to perform database operations.

    private final UserProfileDao userProfileDao;

    public UserProfileCliApiImplementation(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    // Implement methods from UserProfileApi interface here
}
