package com.example.webapp.application.domain.models.users;

import com.example.webapp.application.domain.exceptions.DomainValidationException;

import java.util.Objects;

public class UserRole {
    private final Long id;
    private final Long idUser;
    private final String roleName;

    private UserRole(Long id, Long idUser, String roleName) {
        this.id = id;
        this.idUser = idUser;
        this.roleName = roleName;
    }

    public static UserRole create(Long idUser, String roleName){
        validateRoleName(roleName);
        return new UserRole(null, idUser, roleName);
    }

    public static void validateRoleName(String roleName){
        if (roleName == null || roleName.trim().isEmpty()) {
            throw new DomainValidationException("profileName", "Numele rolului de utilizator nu poate fi null sau gol");
        }
        if (roleName.length() > 100 || roleName.length() < 7) {
            throw new DomainValidationException("profileName", "Numele rolului de utilizator nu poate depăși 30 caractere si nu poate fi mai mic de 6 caractere");
        }
    }

    public Long getId() {
        return id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(id, userRole.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
