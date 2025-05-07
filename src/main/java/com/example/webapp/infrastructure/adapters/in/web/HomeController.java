package com.example.webapp.infrastructure.adapters.in.web;

import com.example.webapp.application.domain.models.UserProfile;
import com.example.webapp.application.dto.query.UserActiveProfileDto;
import com.example.webapp.application.dto.query.UserProfileDto;
import com.example.webapp.application.ports.in.web.UserProfileWebApi;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserActiveProfileRepository;
import com.example.webapp.infrastructure.config.security.profile.UserActiveProfileProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpringMVCViewInspection")
@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    @Value("${spring.profiles.active}")
    private String activeAppProfile;
    
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.description}")
    private String applicationDescription;

    @Value("${spring.application.developer.short}")
    private String applicationDeveloperShort;

    @Value("${spring.application.developer.long}")
    private String applicationDeveloperLong;

    @Value("${spring.application.version}")
    private String applicationVersion;

    private final UserActiveProfileProvider userActiveProfileProvider;

    private final UserProfileWebApi userProfileWebApi;

    private final UserActiveProfileRepository userActiveProfileRepository;

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        log.info("Home endpoint accessed with active profile: {}", activeAppProfile);

        List<UserProfile> userProfileList = userProfileWebApi
                .showUserProfiles(userActiveProfileProvider.getIdUser());

        List<UserProfileDto> userProfileNotActiveList = userProfileList.stream()
                .map(userProfile -> new UserProfileDto(
                        userProfile.getId(),
                        userProfile.getIdUser(),
                        userProfile.getProfileName()))
                .filter(userProfileDto -> !userProfileDto.id().equals(userActiveProfileProvider.getIdProfile()))
                .toList();

          // Opțiunile de meniu pentru navigarea din sidebar
        List<Map<String, String>> menuItems = Arrays.asList(
            Map.of("id", "notifications", "name", "Mesaje", "icon", "envelope", "link", "/partials/notifications"),
            Map.of("id", "intro", "name", "Introducere", "icon", "save2", "link", "/partials/intro"),
            Map.of("id", "search", "name", "Căutare", "icon", "search", "link", "/partials/search"),
            Map.of("id", "valorification", "name", "Valorificare", "icon", "clipboard2-data-fill", "link", "/partials/valorification"),
            Map.of("id", "admin", "name", "Administrare", "icon", "gear", "link", "/partials/admin")
        );
        
        // Obținem context path-ul pentru utilizare în template
        String contextPath = request.getContextPath();

        String usernameFromDatabaseContext = userActiveProfileRepository
                .getUsernameFromDatabaseContext(userActiveProfileProvider.getUsername());
        log.info("Username from database context: {}", usernameFromDatabaseContext);          // Adăugăm datele în model pentru template
        model.addAttribute("appName", applicationName);
        model.addAttribute("appDescription", applicationDescription);
        model.addAttribute("appDeveloperShort", applicationDeveloperShort);
        model.addAttribute("appDeveloperLong", applicationDeveloperLong);
        model.addAttribute("activeAppProfile", activeAppProfile);
        model.addAttribute("currentUserProfile", userActiveProfileProvider);
        model.addAttribute("userProfileNotActiveList", userProfileNotActiveList);
        model.addAttribute("usernameFromDatabaseContext", usernameFromDatabaseContext);
        model.addAttribute("menuItems", menuItems);
        model.addAttribute("contextPath", contextPath);
        model.addAttribute("appVersion", applicationVersion);
        
        return "dashboard";
    }
}