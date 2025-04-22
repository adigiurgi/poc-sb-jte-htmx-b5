package com.example.webapp.application.domain.service.cli;

import com.example.webapp.application.ports.in.cli.UserAppCliApi;
import com.example.webapp.application.ports.out.database.UserAppDao;

public class UserAppCliApiImplementation implements UserAppCliApi {
    // This class implements the UserApi interface and provides the necessary methods to interact with the user data.
    // It uses the UserDao interface to perform database operations.

    private final UserAppDao userAppDao;

    public UserAppCliApiImplementation(UserAppDao userAppDao) {
        this.userAppDao = userAppDao;
    }

    // Implement methods from UserApi interface here
}
