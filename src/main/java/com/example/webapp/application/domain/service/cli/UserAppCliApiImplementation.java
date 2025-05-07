package com.example.webapp.application.domain.service.cli;

import com.example.webapp.application.domain.models.UserApp;
import com.example.webapp.application.dto.command.UserAppCreateDto;
import com.example.webapp.application.ports.in.cli.UserAppCliApi;
import com.example.webapp.application.ports.out.database.UserAppDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserAppCliApiImplementation implements UserAppCliApi {
    private final UserAppDao userAppDao;

    public UserAppCliApiImplementation(UserAppDao userAppDao) {
        this.userAppDao = userAppDao;
    }

    @Override
    public Long createUser(UserAppCreateDto userAppCreateDto) {
        log.info("Creating new user with username: {}", userAppCreateDto.username());

        UserApp userApp = UserApp.create(userAppCreateDto.username(),
                userAppCreateDto.firstName(),
                userAppCreateDto.lastName());

        Long userId = userAppDao.saveUser(userApp);
        log.info("User created successfully with ID: {}", userId);

        return userId;
    }
}
