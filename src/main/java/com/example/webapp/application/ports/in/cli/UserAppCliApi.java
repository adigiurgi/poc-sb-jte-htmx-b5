package com.example.webapp.application.ports.in.cli;

import com.example.webapp.application.dto.command.UserAppCreateDto;

public interface UserAppCliApi {
    /**
     * Creates a new user in the system
     * @param userAppCreateDto Data for creating the user
     * @return ID of the created user
     */
    Long createUser(UserAppCreateDto userAppCreateDto);
}
