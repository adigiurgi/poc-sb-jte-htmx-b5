package com.example.webapp.infrastructure.adapters.in.web;

import com.example.webapp.application.domain.models.notifications.forms.NotificationFormsCard;
import com.example.webapp.application.domain.models.notifications.forms.NotificationFormsForModule;
import com.example.webapp.application.ports.in.web.NotificationFormsApi;
import com.example.webapp.infrastructure.config.security.profile.UserActiveProfileProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SuppressWarnings("SpringMVCViewInspection")
@Slf4j
@Controller
@RequestMapping("/partials")
@RequiredArgsConstructor
public class PartialsController {

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

    private final NotificationFormsApi notificationFormsApi;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm", Locale.getDefault());

    @GetMapping("/notifications-forms")
    public String notificationsForms(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(3000); // Simulăm o întârziere de 1 secundă pentru a simula un apel de rețea
        log.debug("Accesare conținut parțial pentru notificări");
        model.addAttribute("userRoles", notificationFormsApi.findAllUserRoles(userActiveProfileProvider.getIdUser()));
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/notifications-forms";
    }

    @GetMapping("/notifications-forms-module-card/{roleName}")
    public String notificationsFormsModuleCard(Model model, HttpServletRequest request, @PathVariable String roleName) throws InterruptedException {
        //Thread.sleep(3000); // Simulăm o întârziere de 1 secundă pentru a simula un apel de rețea
        log.debug("Accesare conținut parțial pentru cardul aferent modulului {}", roleName);

//        NotificationFormsForModule notification = notificationFormsApi.processNotificationsForModule(userActiveProfileProvider.getAuthenticatedUser(),
//                userActiveProfileProvider.getIdProfile(), roleName);

        NotificationFormsCard notificationFormsCard = notificationFormsApi.processNotifications(userActiveProfileProvider.getAuthenticatedUser(),
                userActiveProfileProvider.getIdProfile(), roleName);


        model.addAttribute("notificationsCount", notificationFormsCard.getNotificationsCount());
        model.addAttribute("executionDurationTimeInSeconds", notificationFormsCard.getExecutionDurationTimeInSeconds());
        model.addAttribute("executionTime", FORMATTER.format(OffsetDateTime.now()));
        model.addAttribute("notificationFormsList", notificationFormsCard.getNotificationFormsList());

        model.addAttribute("contextPath", request.getContextPath());
        model.addAttribute("roleName", roleName);

        return "partials/notifications-forms-module-card";
    }

    @GetMapping("/notifications-forms-module-card-refreshed/{roleName}")
    public String notificationsFormsModuleCardRefreshed(Model model, HttpServletRequest request, @PathVariable String roleName) throws InterruptedException {
        //Thread.sleep(3000); // Simulăm o întârziere de 1 secundă pentru a simula un apel de rețea
        log.debug("Accesare conținut parțial pentru cardul refreshuit aferent modulului {}", roleName);

        model.addAttribute("contextPath", request.getContextPath());
        model.addAttribute("roleName", roleName);

        return "partials/notifications-forms-module-card-refreshed";
    }

    @GetMapping("/notifications-forms-details")
    public String notificationsFormsDetails(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(3000); // Simulăm o întârziere de 1 secundă pentru a simula un apel de rețea
        log.debug("Accesare conținut parțial pentru detalii notificări");
        model.addAttribute("contextPath", request.getContextPath());
        model.addAttribute("currentUserProfile", userActiveProfileProvider);
        model.addAttribute("appName", applicationName);
        model.addAttribute("appDescription", applicationDescription);
        model.addAttribute("appDeveloperShort", applicationDeveloperShort);
        model.addAttribute("appDeveloperLong", applicationDeveloperLong);
        model.addAttribute("activeAppProfile", activeAppProfile);
        model.addAttribute("appVersion", applicationVersion);
        return "partials/notifications-forms-details";
    }

    @GetMapping("/notifications-web")
    public String notificationsWeb(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(3000); // Simulăm o întârziere de 1 secundă pentru a simula un apel de rețea
        log.debug("Accesare conținut parțial pentru notificările noi");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/notifications-web";
    }

    @GetMapping("/intro")
    public String intro(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(3000);
        log.debug("Accesare conținut parțial pentru introducere");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/intro";
    }

    @GetMapping("/search")
    public String search(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(3000);
        log.debug("Accesare conținut parțial pentru căutare");
        //throw new UnsupportedOperationException("Funcționalitate neimplementată");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/search";
    }

    @GetMapping("/valorification")
    public String valorification(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(2000);
        log.debug("Accesare conținut parțial pentru valorificare");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/valorification";
    }

    @GetMapping("/admin")
    public String admin(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(3000);
        log.debug("Accesare conținut parțial pentru administrare");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/admin";
    }

    @GetMapping("/user-guide")
    public String userGuide(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(3000);
        log.debug("Accesare conținut parțial pentru ghidul de utilizare");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/user-guide";
    }

    @GetMapping("/changelog")
    public String changelog(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(3000);
        log.debug("Accesare conținut parțial pentru changelog");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/changelog";
    }
}
