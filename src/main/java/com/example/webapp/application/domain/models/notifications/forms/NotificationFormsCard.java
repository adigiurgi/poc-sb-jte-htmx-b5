package com.example.webapp.application.domain.models.notifications.forms;

import java.util.List;

public class NotificationFormsCard {

    private final String moduleName;

    private final int notificationsCount;

    private final float executionDurationTimeInSeconds;

    private final List<NotificationForms> notificationFormsList;

    public static NotificationFormsCard create (String moduleName, int notificationsCount,
                                                float executionDurationTimeInSeconds,
                                                List<NotificationForms> notificationFormsList) {
        return new NotificationFormsCard(moduleName, notificationsCount,
                executionDurationTimeInSeconds, notificationFormsList);
    }

    public NotificationFormsCard(String moduleName, int notificationsCount,
                                 float executionDurationTimeInSeconds,
                                 List<NotificationForms> notificationFormsList) {
        this.moduleName = moduleName;
        this.notificationsCount = notificationsCount;
        this.executionDurationTimeInSeconds = executionDurationTimeInSeconds;
        this.notificationFormsList = notificationFormsList;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getNotificationsCount() {
        return notificationsCount;
    }

    public float getExecutionDurationTimeInSeconds() {
        return executionDurationTimeInSeconds;
    }

    public List<NotificationForms> getNotificationFormsList() {
        return notificationFormsList;
    }
}
