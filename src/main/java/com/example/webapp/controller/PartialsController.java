package com.example.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/partials")
public class PartialsController {

    @GetMapping("/notifications")
    public String notifications(Model model, HttpServletRequest request) {
        log.debug("Accesare conținut parțial pentru notificări");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/notifications";
    }

    @GetMapping("/intro")
    public String intro(Model model, HttpServletRequest request) {
        log.debug("Accesare conținut parțial pentru introducere");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/intro";
    }

    @GetMapping("/search")
    public String search(Model model, HttpServletRequest request) {
        log.debug("Accesare conținut parțial pentru căutare");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/search";
    }

    @GetMapping("/valorification")
    public String valorification(Model model, HttpServletRequest request) {
        log.debug("Accesare conținut parțial pentru valorificare");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/valorification";
    }

    @GetMapping("/admin")
    public String admin(Model model, HttpServletRequest request) {
        log.debug("Accesare conținut parțial pentru administrare");
        model.addAttribute("contextPath", request.getContextPath());
        return "partials/admin";
    }
}
