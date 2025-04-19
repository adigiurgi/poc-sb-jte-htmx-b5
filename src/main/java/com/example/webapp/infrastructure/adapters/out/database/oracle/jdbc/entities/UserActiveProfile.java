package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "user_active_profiles")
public record UserActiveProfile(
        @Id
        Long id,
        @Column("id_user")
        Long idUser,
        String username,
        @Column("id_profile")
        Long idProfile,
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
