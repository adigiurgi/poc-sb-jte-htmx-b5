package com.example.webapp.infrastructure.config.security;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserActiveProfileEntity;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserActiveProfileRepository;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserAppRepository;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserProfileRepository;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserRoleRepository;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserAppEntity;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserProfileEntity;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserRoleEntity;
import com.example.webapp.infrastructure.config.security.profile.UserActiveProfileProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class SecurityInterceptor implements HandlerInterceptor {

    private final UserActiveProfileProvider userActiveProfileProvider;
    private final UserAppRepository userAppRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserActiveProfileRepository userActiveProfileRepository;

    @Value("${app.required.role}")
    private String requiredRole;

    @Value("${app.error.url}")
    private String accessDeniedUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String authenticatedUser = userActiveProfileProvider.getAuthenticatedUser();
        log.info("[SecurityInterceptor] Authenticated user:  {}",authenticatedUser);

        if (!userHasRequiredRole(authenticatedUser)) {
            log.warn("User {} does not have the required role: {}", authenticatedUser, requiredRole);
            sendToAccessDeniedWithMessage(response);
        }

        if (!setupUserActiveProfile(authenticatedUser)) {
            log.warn("User {} has no profiles configured", authenticatedUser);
            sendToAccessDeniedWithMessage(response);
        }

        return true;
    }

    private boolean userHasRequiredRole(String authenticatedUser) {
        // First get the user ID
        Long userId = userAppRepository.findByUsername(authenticatedUser)
                .map(UserAppEntity::getId)
                .orElse(null);

        if (userId == null) {
            log.warn("User {} not found in the database", authenticatedUser);
            return false;
        }

        // Check if the user has the required role
        List<String> userRoles = userRoleRepository.findByIdUser(userId).stream()
                .map(UserRoleEntity::getRoleName)
                .toList();
        log.info("Check if {} has role {}", authenticatedUser, requiredRole);
        return userRoles.contains(requiredRole);
    }

    /**
     * Redirect to access denied page with custom message
     */
    private void sendToAccessDeniedWithMessage(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.sendRedirect(accessDeniedUrl + "?message=" +
                java.net.URLEncoder.encode("Rolul necesar pentru accesarea aplicatiei nu este alocat contului dumneavoastră. Vă rugăm contactați administratorii aplicației în acest sens.", StandardCharsets.UTF_8));
    }

    /**
     * Get or create the user's active profile
     */
    private boolean setupUserActiveProfile(String authenticatedUser) {
        // First check if there's an active profile
        Optional<UserActiveProfileEntity> activeProfile = userActiveProfileRepository.findByUsername(authenticatedUser);

        if (activeProfile.isPresent()) {
            // Use existing active profile
            log.info("Use existing active profile {}", activeProfile.get());
            userActiveProfileProvider.updateFromEntity(activeProfile.get());
            return true;
        }

        // No active profile, try to find user ID
        Long userId = userAppRepository.findByUsername(authenticatedUser)
                .map(UserAppEntity::getId)
                .orElse(null);

        if (userId == null) {
            log.warn("User {} not found in the database", authenticatedUser);
            return false;
        }

        // Find the first profile for this user (oldest one)
        List<UserProfileEntity> userProfileEntities = userProfileRepository.findByIdUser(userId);
        if (userProfileEntities.isEmpty()) {
            log.warn("No profiles found for user {}", authenticatedUser);
            return false;
        }

        // Sort by ID (assuming lower ID = older profile) and get the first one
        UserProfileEntity firstProfile = userProfileEntities.stream()
                .min((p1, p2) -> p1.getId().compareTo(p2.getId()))
                .get();

        // Create new active profile record using the first profile
        UserActiveProfileEntity newActiveProfile = UserActiveProfileEntity.builder()
                .idUser(userId)
                .username(authenticatedUser)
                .idProfile(firstProfile.getId())
                .profileName(firstProfile.getProfileName())
                .insertedAt(OffsetDateTime.now())
                .build();

        // Save to database and update provider
        UserActiveProfileEntity savedProfile = userActiveProfileRepository.save(newActiveProfile);
        userActiveProfileProvider.updateFromEntity(savedProfile);

        log.info("Created new active profile for user {}: {}", authenticatedUser, firstProfile.getProfileName());
        return true;
    }
}
