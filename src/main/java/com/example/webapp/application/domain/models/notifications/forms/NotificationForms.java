package com.example.webapp.application.domain.models.notifications.forms;

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

    public static NotificationForms create(Long id, Long idProfile, String moduleName, String tipMesaj,
                                      String textMesaj) {
        return new NotificationForms(id, idProfile, moduleName, tipMesaj, textMesaj);
    }

    public boolean isFluxType() {
        return "DE_AVIZAT".equals(tipMesaj) || "NEAVIZATE".equals(tipMesaj) || "FARA_RASPUNS".equals(tipMesaj);
    }

    public boolean isInformativeType() {
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
