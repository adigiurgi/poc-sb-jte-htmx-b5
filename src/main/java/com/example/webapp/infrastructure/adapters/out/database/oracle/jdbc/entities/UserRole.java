package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "user_roles")
public record UserRole(
        @Id
        Long id,
        @Column("id_user")
        Long idUser,
        @Column("role_name")
        String roleName,
        @Column("inserted_at")
        LocalDateTime insertedAt,
        @Column("updated_at")
        LocalDateTime updatedAt,
        @Version
        Integer version
) {
}
