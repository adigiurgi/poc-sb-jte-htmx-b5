package com.example.webapp.application.ports.in.users;

import com.example.webapp.application.dto.command.UserAppCreateDto;
import com.example.webapp.application.dto.command.UserProfileCreateDto;
import com.example.webapp.application.dto.command.UserRoleCreateDto;

public interface UserAdministrationApi {

    /**
     * Creates a new user in the system
     * @param userAppCreateDto Data for creating the user
     * @return ID of the created user
     */
    Long createUser(UserAppCreateDto userAppCreateDto);

    /**
     * Creates a new profile for a user
     * @param userProfileCreateDto Data for creating the profile
     * @return ID of the created profile
     */
    Long createUserProfile(UserProfileCreateDto userProfileCreateDto);

    /**
     * Creates a new role for a user
     * @param userRoleCreateDto Data for creating the role
     * @return ID of the created role
     */
    Long createUserRole(UserRoleCreateDto userRoleCreateDto);
}
