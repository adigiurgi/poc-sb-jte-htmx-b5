package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Table(name = "USER_NOTIFICATIONS_OLD")
@Data
@Builder
public class NotificationForms {
    @Id
    private Long id;
    private Long idProfile;
    private String moduleName;
    private String tipMesaj;
    private String textMesaj;
    private OffsetDateTime insertedAt;
    private OffsetDateTime updatedAt;
}
