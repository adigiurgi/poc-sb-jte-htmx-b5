package com.example.webapp.infrastructure.adapters.in.web;

import com.example.webapp.application.ports.in.web.NotificationWebApi;
import com.example.webapp.infrastructure.config.security.profile.UserActiveProfileProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationsController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm", Locale.getDefault());
    private final NotificationWebApi notificationWebApi;
    private final UserActiveProfileProvider userActiveProfileProvider;

    @GetMapping("/calculate/{moduleName}")
    public String calculateNotificationsForModule(@PathVariable String moduleName,
                                                 Model model,
                                                 HttpServletRequest request) {
        log.info("Calculating notifications for module: {}", moduleName);
        
        Long profileId = userActiveProfileProvider.getIdProfile();
        Long userId = userActiveProfileProvider.getIdUser();
        
        if (profileId == null || userId == null) {
            log.error("Cannot calculate notifications: No active profile or user ID found");
            return "partials/error-card";
        }

        // Check if user has access to this module
        String moduleRole = moduleName + "_ROLE";
        if (!notificationWebApi.hasModuleRole(userId, moduleRole)) {
            log.warn("User {} does not have role {} for module {}", userId, moduleRole, moduleName);
            return "partials/no-access-card";
        }

        // Calculate notifications
        Map<String, Object> result = notificationWebApi.calculateNotificationsForModule(profileId, moduleName);
        
        model.addAttribute("contextPath", request.getContextPath());
        model.addAttribute("moduleName", moduleName);
        model.addAttribute("count", result.get("count"));
        model.addAttribute("executionTime", result.get("executionTime"));
        model.addAttribute("timestamp", FORMATTER.format((OffsetDateTime)result.get("timestamp")));
        
        return "partials/notification-card-body";
    }

    @GetMapping("/count/{moduleName}")
    @ResponseBody
    public Map<String, Object> getNotificationsCount(@PathVariable String moduleName) {
        Map<String, Object> result = new HashMap<>();
        Long profileId = userActiveProfileProvider.getIdProfile();
        
        if (profileId == null) {
            result.put("error", "No active profile found");
            return result;
        }
        
        int count = notificationWebApi.countNotificationsByModule(profileId, moduleName);
        result.put("count", count);
        return result;
    }

    @GetMapping("/details/{moduleName}")
    public String getNotificationsDetails(@PathVariable String moduleName,
                                          Model model,
                                          HttpServletRequest request) {
        log.info("Getting notification details for module: {}", moduleName);
        
        Long profileId = userActiveProfileProvider.getIdProfile();
        
        if (profileId == null) {
            log.error("Cannot get notification details: No active profile found");
            return "partials/error-card";
        }
        
        model.addAttribute("contextPath", request.getContextPath());
        model.addAttribute("moduleName", moduleName);
        model.addAttribute("notifications", notificationWebApi.getNotificationsForModule(profileId, moduleName));
        model.addAttribute("currentUserProfile", userActiveProfileProvider);
        
        return "partials/notifications-forms-details";
    }
}
