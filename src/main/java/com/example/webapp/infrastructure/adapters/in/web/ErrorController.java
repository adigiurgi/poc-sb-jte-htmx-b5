package com.example.webapp.infrastructure.adapters.in.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for handling custom error pages
 */
@Controller
@RequestMapping("/error")
@Slf4j
public class ErrorController {

    @GetMapping("/access-denied")
    public String accessDenied(
            Model model, 
            HttpServletRequest request,
            @RequestParam(required = false, defaultValue = "Nu aveți acces la această aplicație.") String message) {
        
        log.warn("Access denied for user: {}", request.getRemoteUser());
        model.addAttribute("message", message);
        model.addAttribute("contextPath", request.getContextPath());
        return "errors/access-denied";
    }
}
