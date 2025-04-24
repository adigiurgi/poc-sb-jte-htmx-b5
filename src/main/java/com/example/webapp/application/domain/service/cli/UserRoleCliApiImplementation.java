package com.example.webapp.application.domain.service.cli;

import com.example.webapp.application.domain.models.UserRole;
import com.example.webapp.application.dto.command.UserRoleCreateDto;
import com.example.webapp.application.ports.in.cli.UserRoleCliApi;
import com.example.webapp.application.ports.out.database.UserRoleDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRoleCliApiImplementation implements UserRoleCliApi {
    private final UserRoleDao userRoleDao;

    public UserRoleCliApiImplementation(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public Long createUserRole(UserRoleCreateDto userRoleCreateDto) {
        log.info("Creating new role for user ID: {} with name: {}",
                userRoleCreateDto.idUser(), userRoleCreateDto.roleName());
        UserRole userRole = UserRole.create(userRoleCreateDto.idUser(),
                userRoleCreateDto.roleName());
        Long roleId = userRoleDao.saveUserRole(userRole);
        log.info("Role created successfully with ID: {}", roleId);
        
        return roleId;
    }
}
