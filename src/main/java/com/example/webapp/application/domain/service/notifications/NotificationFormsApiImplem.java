package com.example.webapp.application.domain.service.notifications;

import com.example.webapp.application.domain.models.notifications.forms.NotificationForms;
import com.example.webapp.application.domain.models.notifications.forms.NotificationFormsCard;
import com.example.webapp.application.dto.query.UserRoleDto;
import com.example.webapp.application.ports.in.notifications.NotificationFormsApi;
import com.example.webapp.application.ports.out.database.notifications.NotificationFormsDao;
import com.example.webapp.application.ports.out.database.users.UserRoleDao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    public NotificationFormsCard processNotifications(String username, Long idProfile, String moduleName) {

        long start = System.currentTimeMillis();
        notificationFormsDao.calculateNotificationsForModule(username, moduleName);
        List<NotificationForms> notificationForms = notificationFormsDao.getNotificationFormsByProfileAndModule(idProfile, moduleName);

        long end = System.currentTimeMillis();
        float executionTimeInSeconds = (float)(end - start) / 1000.0F;

        return NotificationFormsCard.create(moduleName,
                extractNotificationsCountFromTextMessages(notificationForms),
                executionTimeInSeconds, notificationForms);
    }

    public static int extractNotificationsCountFromTextMessages(List<NotificationForms> notificationFormsList) {
        Pattern pattern = Pattern.compile("\\d+");

        return notificationFormsList.stream()
                .map(NotificationForms::getTextMesaj)
                .mapToInt(text -> {
                    Matcher matcher = pattern.matcher(text);
                    return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
                })
                .sum();
    }
}
