package com.example.webapp.application.domain.models.notifications.forms;

import com.example.webapp.application.domain.exceptions.DomainValidationException;

public class NotificationForms {

    private final Long id;
    private final Long idProfile;
    private final String moduleName;
    private final String tipMesaj;
    private final String textMesaj;

    private NotificationForms(Long id, Long idProfile, String moduleName, String tipMesaj, String textMesaj) {
        this.id = id;
        this.idProfile = idProfile;
        this.moduleName = moduleName;
        this.tipMesaj = tipMesaj;
        this.textMesaj = textMesaj;
    }

    public static NotificationForms create(Long id, Long idProfile, String moduleName, String tipMesaj, String textMesaj) {
        validateModuleName(moduleName);
        validateTipMesaj(tipMesaj);
        validateTextMesaj(textMesaj);
        return new NotificationForms(id, idProfile, moduleName, tipMesaj, textMesaj);
    }

    private static void validateModuleName(String moduleName) {
        if (moduleName == null || moduleName.trim().isEmpty()) {
            throw new DomainValidationException("moduleName", "Numele modulului nu poate fi null sau gol");
        }
    }

    private static void validateTipMesaj(String tipMesaj) {
        if (tipMesaj == null || tipMesaj.trim().isEmpty()) {
            throw new DomainValidationException("moduleName", "Tipul de mesaj nu poate fi null sau gol");
        }
    }

    private static void validateTextMesaj(String textMesaj) {
        if (textMesaj == null || textMesaj.trim().isEmpty()) {
            throw new DomainValidationException("moduleName", "Textul mesajului nu poate fi null sau gol");
        }
    }

    public boolean isNormalStatus() {
        return "BENEFICIAR_PUS".equals(tipMesaj) || "NEAVIZATE".equals(tipMesaj) || "REZOLUTIE_PUSA".equals(tipMesaj);
    }

    public boolean isPriorityStatus() {
        return "DE_AVIZAT".equals(tipMesaj);
    }

    public boolean isUrgentStatus() {
        return "FARA_RASPUNS".equals(tipMesaj);
    }

    public boolean canBeDismissed() {
        return "BENEFICIAR_PUS".equals(tipMesaj) || "REZOLUTIE_PUSA".equals(tipMesaj);
    }

    public Long getId() {
        return id;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getTipMesaj() {
        return tipMesaj;
    }

    public String getTextMesaj() {
        return textMesaj;
    }
}
