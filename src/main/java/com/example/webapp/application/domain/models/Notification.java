package com.example.webapp.application.domain.models;

import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@ToString
public class Notification {
    private final Long id;
    private final Long idProfile;
    private final String moduleName;
    private final String tipMesaj;
    private final String textMesaj;
    private final OffsetDateTime insertedAt;
    private final OffsetDateTime updatedAt;

    private Notification(Long id, Long idProfile, String moduleName, String tipMesaj, String textMesaj, 
                        OffsetDateTime insertedAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.idProfile = idProfile;
        this.moduleName = moduleName;
        this.tipMesaj = tipMesaj;
        this.textMesaj = textMesaj;
        this.insertedAt = insertedAt;
        this.updatedAt = updatedAt;
    }

    public static Notification create(Long id, Long idProfile, String moduleName, String tipMesaj, 
                                    String textMesaj, OffsetDateTime insertedAt, OffsetDateTime updatedAt) {
        return new Notification(id, idProfile, moduleName, tipMesaj, textMesaj, insertedAt, updatedAt);
    }

    public boolean isFluxType() {
        return "DE_AVIZAT".equals(tipMesaj) || "NEAVIZATE".equals(tipMesaj) || "FARA_RASPUNS".equals(tipMesaj);
    }

    public boolean isInformativeType() {
        return "BENEFICIAR_PUS".equals(tipMesaj) || "REZOLUTIE_PUSA".equals(tipMesaj);
    }
}
