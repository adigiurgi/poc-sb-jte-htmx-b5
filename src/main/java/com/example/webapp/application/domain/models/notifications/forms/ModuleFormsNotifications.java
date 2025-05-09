package com.example.webapp.application.domain.models.notifications.forms;

import java.time.OffsetDateTime;

public class ModuleFormsNotifications {

    private final String moduleName;

    private final int notificationsCount;

    private final int executionTimeInSeconds;

    private ModuleFormsNotifications(String moduleName, int notificationsCount, int executionTimeInSeconds){
        this.moduleName = moduleName;
        this.notificationsCount = notificationsCount;
        this.executionTimeInSeconds = executionTimeInSeconds;
    }

    public static ModuleFormsNotifications create(String moduleName, int notificationsCount, int executionTimeInSeconds) {
        return new ModuleFormsNotifications(moduleName, notificationsCount, executionTimeInSeconds);
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getNotificationsCount() {
        return notificationsCount;
    }

    public int getExecutionTime() {
        return executionTimeInSeconds;
    }
}
