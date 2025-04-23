package com.example.webapp.infrastructure.config.security;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserActiveProfile;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.time.OffsetDateTime;

/**
 * Request-scoped bean that holds the current user's active profile information.
 * This bean is created for each HTTP request and is available throughout the request lifecycle.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
public class UserActiveProfileProvider {
    private Long id;
    private Long idUser;
    private String username;
    private Long idProfile;
    private String profileName;
    private OffsetDateTime insertedAt;
    private OffsetDateTime updatedAt;
    private Integer version;
    
    /**
     * Updates this provider with data from a UserActiveProfile entity
     */
    public void updateFromEntity(UserActiveProfile profile) {
        this.id = profile.getId();
        this.idUser = profile.getIdUser();
        this.username = profile.getUsername();
        this.idProfile = profile.getIdProfile();
        this.profileName = profile.getProfileName();
        this.insertedAt = profile.getInsertedAt();
        this.updatedAt = profile.getUpdatedAt();
        this.version = profile.getVersion();
    }
}
