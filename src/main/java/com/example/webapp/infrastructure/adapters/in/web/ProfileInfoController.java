package com.example.webapp.infrastructure.adapters.in.web;

import com.example.webapp.infrastructure.config.security.UserActiveProfileProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller that demonstrates injecting and using the UserActiveProfileProvider
 */
@Controller
@RequestMapping("/profile-info")
@RequiredArgsConstructor
@Slf4j
public class ProfileInfoController {

    private final UserActiveProfileProvider profileProvider;
    
    @GetMapping
    public String getProfileInfo(Model model, HttpServletRequest request) {
        log.info("Current active profile for user: {} is: {}", 
                profileProvider.getUsername(), 
                profileProvider.getProfileName());
                
        model.addAttribute("profile", profileProvider);
        model.addAttribute("contextPath", request.getContextPath());
        
        return "profile-info";
    }
}
