package com.example.webapp.application.domain.models;

import com.example.webapp.application.domain.exceptions.DomainValidationException;

import java.util.Objects;


public class User {
    private Long id;
    private final String username;
    private final String firstName;
    private final String lastName;

    private User(Long id, String username, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static User create(String username, String firstName, String lastName) {
        validateUsername(username);
        validateFirstName(firstName);
        validateLastName(lastName);
        return new User(null, username, firstName, lastName);
    }

    private static void validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new DomainValidationException("name", "Numele de utilizator nu poate fi null sau gol");
        }
        if (username.length() > 30) {
            throw new DomainValidationException("name", "Numele de utilizator nu poate depăși 30 caractere");
        }
    }

    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new DomainValidationException("name", "Prenumele nu poate fi null sau gol");
        }
        if (firstName.length() > 30) {
            throw new DomainValidationException("name", "Prenumele nu poate depăși 30 caractere");
        }
    }

    private static void validateLastName(String  lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new DomainValidationException("name", "Numele de familie nu poate fi null sau gol");
        }
        if (lastName.length() > 30) {
            throw new DomainValidationException("name", "Numele de familie nu poate depăși 30 caractere");
        }
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                '}';
    }
}
