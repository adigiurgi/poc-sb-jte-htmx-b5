package com.example.webapp.infrastructure.adapters.in.web;

import com.example.webapp.application.dto.query.UserActiveProfileDto;
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
    private String activeProfile;
    
    @Value("${spring.application.name}")
    private String applicationName;

    private final UserActiveProfileProvider userActiveProfileProvider;

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        log.info("Home endpoint accessed with active profile: {}", activeProfile);
        
        // Date hardcodate despre profilul activ al utilizatorului
        UserActiveProfileDto currentUserProfile = new UserActiveProfileDto(
            1L,
            1L,
                userActiveProfileProvider.getAuthenticatedUser(),
            1L,
            "Administrator");

          // Opțiunile de meniu pentru navigarea din sidebar
        List<Map<String, String>> menuItems = Arrays.asList(
            Map.of("id", "notifications", "name", "Notificări", "icon", "bell", "link", "/partials/notifications"),
            Map.of("id", "intro", "name", "Introducere", "icon", "info-circle", "link", "/partials/intro"),
            Map.of("id", "search", "name", "Căutare", "icon", "search", "link", "/partials/search"),
            Map.of("id", "valorification", "name", "Valorificare", "icon", "chart-line", "link", "/partials/valorification"),
            Map.of("id", "admin", "name", "Administrare", "icon", "gear", "link", "/partials/admin")
        );
        
        // Obținem context path-ul pentru utilizare în template
        String contextPath = request.getContextPath();
          // Adăugăm datele în model pentru template
        model.addAttribute("appName", applicationName);
        model.addAttribute("activeProfile", activeProfile);
        model.addAttribute("currentUserProfile", currentUserProfile);
        model.addAttribute("menuItems", menuItems);
        model.addAttribute("contextPath", contextPath);
        
        return "dashboard";
    }
}