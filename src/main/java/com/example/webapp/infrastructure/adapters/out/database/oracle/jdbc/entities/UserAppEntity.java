package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Table(name = "USER_APP")
@Data
@Builder
public class UserAppEntity {
        @Id
        private Long id;
        private String username;
        private String firstName;
        private String lastName;
        private OffsetDateTime insertedAt;
        private OffsetDateTime updatedAt;
        @Version
        private Long version;

}
