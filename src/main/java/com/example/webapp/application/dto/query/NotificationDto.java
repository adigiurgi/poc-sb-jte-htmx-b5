package com.example.webapp.application.dto.query;

import java.time.OffsetDateTime;

public record NotificationDto(
    Long id,
    Long idProfile,
    String moduleName,
    String tipMesaj,
    String textMesaj,
    OffsetDateTime insertedAt,
    OffsetDateTime updatedAt
) {
    public boolean isFluxType() {
        return "DE_AVIZAT".equals(tipMesaj) || "NEAVIZATE".equals(tipMesaj) || "FARA_RASPUNS".equals(tipMesaj);
    }

    public boolean isInformativeType() {
        return "BENEFICIAR_PUS".equals(tipMesaj) || "REZOLUTIE_PUSA".equals(tipMesaj);
    }
}
