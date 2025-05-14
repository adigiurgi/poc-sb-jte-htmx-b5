package com.example.webapp.application.ports.in.notifications;

import com.example.webapp.application.domain.models.notifications.forms.NotificationFormsCard;
import com.example.webapp.application.dto.query.UserRoleDto;

import java.util.List;

public interface NotificationFormsApi {

    List<UserRoleDto> findAllUserRoles(Long idUser);

    NotificationFormsCard processNotifications(String username, Long idProfile, String moduleName);
}
