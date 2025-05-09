package com.example.webapp.application.dto.query;

public record ModuleFormsNotificationsDto(
        String moduleName,
        int notificationsCount,
        int executionTimeInSeconds
) {
}
