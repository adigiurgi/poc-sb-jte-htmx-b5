package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "user_app")
public record UserApp(
        @Id
        Long id,
        String username,
        @Column("first_name")
        String firstName,
        @Column("last_name")
        String lastName,
        @Column("inserted_at")
        LocalDateTime insertedAt,
        @Column("updated_at")
        LocalDateTime updatedAt,
        @Version
        Integer version
) {
}
