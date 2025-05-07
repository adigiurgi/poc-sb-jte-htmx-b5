package com.example.webapp.infrastructure.adapters.in.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("SpringMVCViewInspection")
@Slf4j
@Controller
@RequestMapping("/partials")
public class PartialsController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.version}")
    private String applicationVersion;

    @GetMapping("/notifications-forms")
    public String notifications(Model model, HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(3000); // Simulăm o întârziere de 1 secundă pentru a simula un apel de rețea
        log.debug("Accesare conținut parțial pentru notificări");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/notifications-forms";
    }

    @GetMapping("/notifications-web")
    public String notificationsNew(Model model, HttpServletRequest request) throws InterruptedException {
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
