package com.example.webapp.infrastructure.config.security.profile;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserActiveProfileEntity;
import com.example.webapp.infrastructure.config.security.user.UserProvider;
import lombok.*;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.time.OffsetDateTime;

/**
 * Request-scoped bean that holds the current user's active profile information.
 * This bean is created for each HTTP request and is available throughout the request lifecycle.
 */
@Component
@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserActiveProfileProvider {

    final UserProvider userProvider;

    private Long id;
    private Long idUser;
    private String username;
    private Long idProfile;
    private String profileName;
    private OffsetDateTime insertedAt;
    private OffsetDateTime updatedAt;
    private Integer version;


    public String getAuthenticatedUser(){
        return this.userProvider.getAuthenticatedUser();
    }
    /**
     * Updates this provider with data from a UserActiveProfile entity
     */
    public void updateFromEntity(UserActiveProfileEntity profile) {
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
