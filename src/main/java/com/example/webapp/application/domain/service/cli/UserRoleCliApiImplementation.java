package com.example.webapp.application.domain.service.cli;

import com.example.webapp.application.ports.in.cli.UserRoleCliApi;
import com.example.webapp.application.ports.out.database.UserRoleDao;

public class UserRoleCliApiImplementation implements UserRoleCliApi {
    private final UserRoleDao userRoleDao;

    public UserRoleCliApiImplementation(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }
}
