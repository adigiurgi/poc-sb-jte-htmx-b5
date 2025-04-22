package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Table(name = "user_app")
@Data
@Builder
public class UserApp {
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
