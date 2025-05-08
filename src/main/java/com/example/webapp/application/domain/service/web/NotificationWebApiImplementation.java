package com.example.webapp.application.domain.service.web;

import com.example.webapp.application.domain.models.Notification;
import com.example.webapp.application.dto.query.NotificationDto;
import com.example.webapp.application.ports.in.web.NotificationWebApi;
import com.example.webapp.application.ports.out.database.NotificationDao;
import com.example.webapp.application.ports.out.database.UserRoleDao;
import lombok.extern.slf4j.Slf4j;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class NotificationWebApiImplementation implements NotificationWebApi {
    
    private final NotificationDao notificationDao;
    private final UserRoleDao userRoleDao;
    
    public NotificationWebApiImplementation(NotificationDao notificationDao, UserRoleDao userRoleDao) {
        this.notificationDao = notificationDao;
        this.userRoleDao = userRoleDao;
    }

    @Override
    public Map<String, Object> calculateNotificationsForModule(Long idProfile, String moduleName) {
        log.info("Calculating notifications for profile ID: {} and module: {}", idProfile, moduleName);
        Map<String, Object> result = new HashMap<>();
        
        long startTime = System.currentTimeMillis();
        long executionTime = notificationDao.calculateNotificationsForModule(idProfile, moduleName);
        int count = notificationDao.countNotificationsByProfileAndModule(idProfile, moduleName);
        
        result.put("count", count);
        result.put("executionTime", executionTime);
        result.put("timestamp", OffsetDateTime.now());
        
        log.info("Calculation complete for module {}. Found {} notifications in {} ms", 
                moduleName, count, executionTime);
        return result;
    }

    @Override
    public List<NotificationDto> getNotificationsForModule(Long idProfile, String moduleName) {
        log.info("Getting notifications for profile ID: {} and module: {}", idProfile, moduleName);
        List<Notification> notifications = notificationDao.getNotificationsByProfileAndModule(idProfile, moduleName);
        
        return notifications.stream()
                .map(n -> new NotificationDto(
                        n.getId(),
                        n.getIdProfile(),
                        n.getModuleName(),
                        n.getTipMesaj(),
                        n.getTextMesaj(),
                        n.getInsertedAt(),
                        n.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    @Override
    public int countNotificationsByModule(Long idProfile, String moduleName) {
        log.info("Counting notifications for profile ID: {} and module: {}", idProfile, moduleName);
        return notificationDao.countNotificationsByProfileAndModule(idProfile, moduleName);
    }

    @Override
    public boolean hasModuleRole(Long idUser, String moduleName) {
        String roleToCheck = moduleName + "_ROLE";
        log.info("Checking if user ID: {} has role: {}", idUser, roleToCheck);
        return userRoleDao.hasRole(idUser, roleToCheck);
    }
}
