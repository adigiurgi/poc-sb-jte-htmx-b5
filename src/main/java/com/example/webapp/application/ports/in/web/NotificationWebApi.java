package com.example.webapp.application.ports.in.web;

import com.example.webapp.application.dto.query.NotificationDto;

import java.util.List;
import java.util.Map;

public interface NotificationWebApi {
    /**
     * Calculate notifications for a specific module
     * @param idProfile The profile ID
     * @param moduleName The name of the module
     * @return Map with count and execution time
     */
    Map<String, Object> calculateNotificationsForModule(Long idProfile, String moduleName);

    /**
     * Get notifications for a specific module
     * @param idProfile The profile ID
     * @param moduleName The name of the module
     * @return List of notifications
     */
    List<NotificationDto> getNotificationsForModule(Long idProfile, String moduleName);
    
    /**
     * Count notifications by module
     * @param idProfile The profile ID
     * @param moduleName The name of the module
     * @return Number of notifications
     */
    int countNotificationsByModule(Long idProfile, String moduleName);
    
    /**
     * Check if user has role for a module
     * @param idUser The user ID
     * @param moduleName The name of the module
     * @return true if the user has the module role
     */
    boolean hasModuleRole(Long idUser, String moduleName);
}
