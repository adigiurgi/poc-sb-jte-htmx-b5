package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "user_profiles")
public record UserProfile(
        @Id
        Long id,
        @Column("id_user")
        Long idUser,
        @Column("profile_name")
        String profileName,
        @Column("inserted_at")
        LocalDateTime insertedAt,
        @Column("updated_at")
        LocalDateTime updatedAt,
        @Version
        Integer version
) {
}
