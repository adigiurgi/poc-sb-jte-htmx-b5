package com.example.webapp.application.domain.models;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserAppEntity;

import java.util.Objects;

public class UserActiveProfile {

    private final Long id;
    private final Long idUser;
    private final String username;
    private final Long idProfile;
    private final String profileName;

    private UserActiveProfile(Long id, Long idUser, String username, Long idProfile, String profileName) {
        this.id = id;
        this.idUser = idUser;
        this.username = username;
        this.idProfile = idProfile;
        this.profileName = profileName;
    }

    //TODO de transmis in constructor UserApp si UserProfile
    public static  UserActiveProfile create(UserApp userApp, UserActiveProfile userActiveProfile) {
        return new UserActiveProfile(null, userApp.getId(), userApp.getUsername(),
                userActiveProfile.getIdProfile(), userActiveProfile.getProfileName());
    }

    public Long getId() {
        return id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserActiveProfile userActiveProfile = (UserActiveProfile) o;
        return Objects.equals(id, userActiveProfile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
