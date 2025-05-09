package com.example.webapp.application.domain.service.web;

import com.example.webapp.application.dto.query.UserRoleDto;
import com.example.webapp.application.ports.in.web.UserFormsNotificationsApi;
import com.example.webapp.application.ports.out.database.UserRoleDao;

import java.util.List;


public class UserFormsNotificationsApiImplem implements UserFormsNotificationsApi {

    private final UserRoleDao userRoleDao;

    public UserFormsNotificationsApiImplem(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public List<UserRoleDto> findAllUserRoles(Long idUser) {
        return userRoleDao.findRolesByIdUser(idUser).stream()
                .map(userRole -> new UserRoleDto(userRole.getIdUser(),
                        userRole.getRoleName()))
                .toList();
    }
}
