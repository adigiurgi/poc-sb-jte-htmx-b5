package com.example.webapp.application.dto.query;

public record NotificationFormsDto(Long id,
                                   Long idProfile,
                                   String moduleName,
                                   String tipMesaj,
                                   String textMesaj
) {
}
