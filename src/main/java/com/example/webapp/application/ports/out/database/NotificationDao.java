package com.example.webapp.application.ports.out.database;

import com.example.webapp.application.domain.models.Notification;
import java.util.List;

public interface NotificationDao {
    /**
     * Retrieves notifications for a specific profile and module
     * 
     * @param idProfile The profile ID
     * @param moduleName The name of the module
     * @return List of notifications
     */
    List<Notification> getNotificationsByProfileAndModule(Long idProfile, String moduleName);
    
    /**
     * Calls the stored procedure to calculate notifications for a module
     * 
     * @param idProfile The profile ID
     * @param moduleName The name of the module (without "MODUL_" prefix)
     * @return The execution time in milliseconds
     */
    long calculateNotificationsForModule(Long idProfile, String moduleName);
    
    /**
     * Counts notifications for a specific profile and module
     * 
     * @param idProfile The profile ID
     * @param moduleName The name of the module
     * @return The number of notifications
     */
    int countNotificationsByProfileAndModule(Long idProfile, String moduleName);
}
