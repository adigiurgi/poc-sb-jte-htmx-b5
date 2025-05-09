package com.example.webapp.application.ports.in.web;

import com.example.webapp.application.dto.query.UserRoleDto;

import java.util.List;

public interface UserFormsNotificationsApi {

    List<UserRoleDto> findAllUserRoles(Long idUser);
}
