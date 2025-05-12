package com.example.webapp.application.domain.service.web;

import com.example.webapp.application.domain.models.notifications.forms.NotificationFormsForModule;
import com.example.webapp.application.dto.query.UserRoleDto;
import com.example.webapp.application.ports.in.web.NotificationFormsApi;
import com.example.webapp.application.ports.out.database.NotificationFormsDao;
import com.example.webapp.application.ports.out.database.UserRoleDao;

import java.util.List;


public class NotificationFormsApiImplem implements NotificationFormsApi {

    private final UserRoleDao userRoleDao;
    private final NotificationFormsDao notificationFormsDao;

    public NotificationFormsApiImplem(UserRoleDao userRoleDao, NotificationFormsDao notificationFormsDao) {

        this.userRoleDao = userRoleDao;
        this.notificationFormsDao = notificationFormsDao;
    }

    @Override
    public List<UserRoleDto> findAllUserRoles(Long idUser) {
        return userRoleDao.findRolesByIdUser(idUser).stream()
                .map(userRole -> new UserRoleDto(userRole.getIdUser(),
                        userRole.getRoleName()))
                .toList();
    }

    @Override
    public NotificationFormsForModule processNotificationsForModule(String username, Long idProfile, String moduleName) {

        long start = System.currentTimeMillis();
        notificationFormsDao.calculateNotificationsForModule(username, moduleName);
        int countNotificationsForModule = notificationFormsDao.countNotificationsByProfileAndModule(idProfile, moduleName);
        long end = System.currentTimeMillis();
        float executionTimeInSeconds = (float)(end - start) / 1000.0F;
        return NotificationFormsForModule.create(moduleName,countNotificationsForModule,executionTimeInSeconds);
    }
}
