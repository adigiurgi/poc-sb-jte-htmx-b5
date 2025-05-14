package com.example.webapp.application.ports.out.database.notifications;

import com.example.webapp.application.domain.models.notifications.forms.NotificationForms;

import java.util.List;

public interface NotificationFormsDao {


    /**
     * Calls the stored procedure to calculate notifications for a module
     * @param username The username of the connected user
     * @param moduleName The name of the module
     */
    void calculateNotificationsForModule(String username, String moduleName);

    /**
     * Counts notifications for a specific profile and module
     *
     * @param idProfile The profile ID
     * @param moduleName The name of the module
     * @return The number of notifications
     */
    int countNotificationsByProfileAndModule(Long idProfile, String moduleName);

    /**
     * Retrieves notifications for a specific profile and module
     *
     * @param idProfile The profile ID
     * @param moduleName The name of the module
     * @return List of notifications
     */
    List<NotificationForms> getNotificationFormsByProfileAndModule(Long idProfile, String moduleName);
}
