package com.example.webapp.application.domain.models;

import com.example.webapp.application.domain.exceptions.DomainValidationException;

import java.util.Objects;

public class UserProfile {

    private final Long id;
    private final Long idUser;
    private final String profileName;

    private UserProfile(Long id, Long idUser, String profileName) {
        this.id = id;
        this.idUser = idUser;
        this.profileName = profileName;
    }

    public static UserProfile create(Long idUser, String profileName){
        validateProfileName(profileName);
        return new UserProfile(null, idUser, profileName);
    }

    public static UserProfile create(Long id, Long idUser, String profileName){
        validateProfileName(profileName);
        return new UserProfile(id, idUser, profileName);
    }

    private static void validateProfileName(String profileName){
        if (profileName == null || profileName.trim().isEmpty()) {
            throw new DomainValidationException("profileName", "Numele profilului de utilizator nu poate fi null sau gol");
        }
        if (profileName.length() > 100 || profileName.length() < 6) {
            throw new DomainValidationException("profileName", "Numele profilului de utilizator nu poate depăși 30 caractere si nu poate fi mai mic de 6 caractere");
        }
    }

    public Long getId() {
        return id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile userProfile = (UserProfile) o;
        return Objects.equals(id, userProfile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
