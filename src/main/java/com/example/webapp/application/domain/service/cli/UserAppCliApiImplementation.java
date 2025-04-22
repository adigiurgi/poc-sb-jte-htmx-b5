package com.example.webapp.application.domain.service.cli;

import com.example.webapp.application.domain.models.User;
import com.example.webapp.application.dto.command.UserAppCreateDto;
import com.example.webapp.application.ports.in.cli.UserAppCliApi;
import com.example.webapp.application.ports.out.database.UserAppDao;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class UserAppCliApiImplementation implements UserAppCliApi {
    private final UserAppDao userAppDao;

    public UserAppCliApiImplementation(UserAppDao userAppDao) {
        this.userAppDao = userAppDao;
    }

    @Override
    public Long createUser(UserAppCreateDto userAppCreateDto) {
        log.info("Creating new user with username: {}", userAppCreateDto.username());
        
        User user = new User(
                null,
                userAppCreateDto.username(),
                userAppCreateDto.email(),
                userAppCreateDto.firstName(),
                userAppCreateDto.lastName(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        
        Long userId = userAppDao.saveUser(user);
        log.info("User created successfully with ID: {}", userId);
        
        return userId;
    }
}
