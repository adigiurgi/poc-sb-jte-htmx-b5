package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.users;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Table(name = "USER_ROLES")
@Data
@Builder
public class UserRoleEntity {
        @Id
        private Long id;
        private Long idUser;
        private String roleName;
        private OffsetDateTime insertedAt;
        private OffsetDateTime updatedAt;
        @Version
        private Integer version;
}
