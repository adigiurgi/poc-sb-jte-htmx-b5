package com.example.webapp.infrastructure.config.security;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserActiveProfile;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserApp;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserProfile;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserRole;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserActiveProfileRepository;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserAppRepository;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserProfileRepository;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Filter that authenticates users and sets up the UserActiveProfileProvider for each request.
 * Runs early in the filter chain to ensure the user profile is available for the entire request.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 100)
@RequiredArgsConstructor
@Slf4j
public class UserAuthenticationFilter extends OncePerRequestFilter {

    private final Environment environment;
    private final UserActiveProfileProvider userProfileProvider;
    private final UserAppRepository userAppRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserActiveProfileRepository userActiveProfileRepository;

    @Value("${sso.remote.user:admin}")
    private String configuredUsername;

    @Value("${app.required.role:APP_ACCESS}")
    private String requiredRole;

    @Value("${app.error.url:/error/access-denied}")
    private String accessDeniedUrl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {
        
        // Skip filter for error pages and static resources
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/error") || requestURI.contains("/static/") || 
            requestURI.contains("/css/") || requestURI.contains("/js/")) {
            filterChain.doFilter(request, response);
            return;
        }
        
        try {
            // Step 1: Get the authenticated username based on active profile
            String username = getAuthenticatedUsername(request);
            log.debug("Processing request for user: {}", username);
            
            // Step 2: Check if user has the required role
            if (!userHasRequiredRole(username)) {
                log.warn("User {} does not have the required role: {}", username, requiredRole);
                sendToAccessDeniedWithMessage(response, "Rolul necesar pentru accesare nu este alocat contului dumneavoastră. Vă rugăm contactați administratorii aplicației.");
                return;
            }
            
            // Step 4 & 5: Get or create active profile
            if (!setupUserActiveProfile(username)) {
                log.warn("User {} has no profiles configured", username);
                sendToAccessDeniedWithMessage(response, "Nu aveți niciun profil configurat. Vă rugăm contactați administratorii aplicației pentru crearea cel puțin a unui profil.");
                return;
            }
            
            // Continue with the request
            filterChain.doFilter(request, response);
            
        } catch (Exception e) {
            log.error("Error during user authentication: {}", e.getMessage(), e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Get the authenticated username based on the active Spring profile
     */
    private String getAuthenticatedUsername(HttpServletRequest request) {
        boolean isProdOrTestEnv = environment.acceptsProfiles(Profiles.of("prod", "test"));
        
        if (isProdOrTestEnv) {
            // In prod/test, get username from SSO
            String remoteUser = request.getRemoteUser();
            if (remoteUser == null || remoteUser.isBlank()) {
                log.warn("No remote user found in SSO for prod/test environment");
                throw new SecurityException("No authenticated user found");
            }
            return remoteUser;
        } else {
            // In dev/local, get username from properties
            log.debug("Using configured username from properties: {}", configuredUsername);
            return configuredUsername;
        }
    }
    
    /**
     * Check if the user has the required application role
     */
    private boolean userHasRequiredRole(String username) {
        // First get the user ID
        Long userId = userAppRepository.findByUsername(username)
                .map(UserApp::getId)
                .orElse(null);
                
        if (userId == null) {
            log.warn("User {} not found in the database", username);
            return false;
        }
        
        // Check if the user has the required role
        List<String> userRoles = userRoleRepository.findByIdUser(userId).stream()
                .map(UserRole::getRoleName)
                .toList();
                
        return userRoles.contains(requiredRole);
    }
    
    /**
     * Get or create the user's active profile
     */
    private boolean setupUserActiveProfile(String username) {
        // First check if there's an active profile
        Optional<UserActiveProfile> activeProfile = userActiveProfileRepository.findByUsername(username);
        
        if (activeProfile.isPresent()) {
            // Use existing active profile
            userProfileProvider.updateFromEntity(activeProfile.get());
            return true;
        }
        
        // No active profile, try to find user ID
        Long userId = userAppRepository.findByUsername(username)
                .map(UserApp::getId)
                .orElse(null);
                
        if (userId == null) {
            log.warn("User {} not found in the database", username);
            return false;
        }
        
        // Find the first profile for this user (oldest one)
        List<UserProfile> userProfiles = userProfileRepository.findByIdUser(userId);
        if (userProfiles.isEmpty()) {
            log.warn("No profiles found for user {}", username);
            return false;
        }
        
        // Sort by ID (assuming lower ID = older profile) and get the first one
        UserProfile firstProfile = userProfiles.stream()
                .min((p1, p2) -> p1.getId().compareTo(p2.getId()))
                .get();
        
        // Create new active profile record using the first profile
        UserActiveProfile newActiveProfile = UserActiveProfile.builder()
                .idUser(userId)
                .username(username)
                .idProfile(firstProfile.getId())
                .profileName(firstProfile.getProfileName())
                .insertedAt(OffsetDateTime.now())
                .build();

        
        // Save to database and update provider
        UserActiveProfile savedProfile = userActiveProfileRepository.save(newActiveProfile);
        userProfileProvider.updateFromEntity(savedProfile);
        
        log.info("Created new active profile for user {}: {}", username, firstProfile.getProfileName());
        return true;
    }
    
    /**
     * Redirect to access denied page with custom message
     */
    private void sendToAccessDeniedWithMessage(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.sendRedirect(accessDeniedUrl + "?message=" + java.net.URLEncoder.encode(message, "UTF-8"));
    }
}
