package com.example.webapp.application.ports.in.web;

import com.example.webapp.application.domain.models.notifications.forms.NotificationFormsForModule;
import com.example.webapp.application.dto.query.UserRoleDto;

import java.util.List;

public interface NotificationFormsApi {

    List<UserRoleDto> findAllUserRoles(Long idUser);

    NotificationFormsForModule processNotificationsForModule(String username, Long idProfile, String moduleName);
}
