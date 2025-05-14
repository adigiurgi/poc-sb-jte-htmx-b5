package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.users;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Table(name = "USER_PROFILES")
@Data
@Builder
public class UserProfileEntity {
        @Id
        private Long id;
        private Long idUser;
        private String profileName;
        private OffsetDateTime insertedAt;
        private OffsetDateTime updatedAt;
        @Version
        private Integer version;
}
