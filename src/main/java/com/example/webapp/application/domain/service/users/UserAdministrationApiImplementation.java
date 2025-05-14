package com.example.webapp.application.domain.service.users;

import com.example.webapp.application.domain.models.users.UserApp;
import com.example.webapp.application.domain.models.users.UserProfile;
import com.example.webapp.application.domain.models.users.UserRole;
import com.example.webapp.application.dto.command.UserAppCreateDto;
import com.example.webapp.application.dto.command.UserProfileCreateDto;
import com.example.webapp.application.dto.command.UserRoleCreateDto;
import com.example.webapp.application.ports.in.users.UserAdministrationApi;
import com.example.webapp.application.ports.out.database.users.UserAppDao;
import com.example.webapp.application.ports.out.database.users.UserProfileDao;
import com.example.webapp.application.ports.out.database.users.UserRoleDao;

public class UserAdministrationApiImplementation implements UserAdministrationApi {

    private final UserAppDao userAppDao;
    private final UserProfileDao userProfileDao;

    private final UserRoleDao userRoleDao;

    public UserAdministrationApiImplementation(UserAppDao userAppDao, UserProfileDao userProfileDao, UserRoleDao userRoleDao) {
        this.userAppDao = userAppDao;
        this.userProfileDao = userProfileDao;
        this.userRoleDao = userRoleDao;
    }

    @Override
    public Long createUser(UserAppCreateDto userAppCreateDto) {

        UserApp userApp = UserApp.create(userAppCreateDto.username(),
                userAppCreateDto.firstName(),
                userAppCreateDto.lastName());

        return userAppDao.saveUser(userApp);
    }

    @Override
    public Long createUserProfile(UserProfileCreateDto userProfileCreateDto) {

        UserProfile userProfile = UserProfile.create(userProfileCreateDto.idUser(),
                userProfileCreateDto.profileName());

        return userProfileDao.saveUserProfile(userProfile);
    }

    @Override
    public Long createUserRole(UserRoleCreateDto userRoleCreateDto) {
        UserRole userRole = UserRole.create(userRoleCreateDto.idUser(),
                userRoleCreateDto.roleName());

        return userRoleDao.saveUserRole(userRole);
    }
}
