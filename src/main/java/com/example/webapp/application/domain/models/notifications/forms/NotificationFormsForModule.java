package com.example.webapp.application.domain.models.notifications.forms;

public class NotificationFormsForModule {

    private final String moduleName;

    private final int notificationsCount;

    private final float executionTimeInSeconds;

    private NotificationFormsForModule(String moduleName, int notificationsCount, float executionTimeInSeconds){
        this.moduleName = moduleName;
        this.notificationsCount = notificationsCount;
        this.executionTimeInSeconds = executionTimeInSeconds;
    }

    public static NotificationFormsForModule create(String moduleName, int notificationsCount, float executionTimeInSeconds) {
        return new NotificationFormsForModule(moduleName, notificationsCount, executionTimeInSeconds);
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getNotificationsCount() {
        return notificationsCount;
    }

    public float getExecutionTime() {
        return executionTimeInSeconds;
    }
}
