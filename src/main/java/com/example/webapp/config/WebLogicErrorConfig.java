package com.example.webapp.config;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Custom error handling configuration for WebLogic environment
 * to resolve the "Circular view path [error]" issue
 */
@Configuration
@Profile("prod")
public class WebLogicErrorConfig {

    /**
     * Custom ErrorViewResolver that prevents circular view paths
     * by explicitly resolving error views to a specific template
     */
    @Bean
    public ErrorViewResolver customErrorViewResolver() {
        return (request, status, model) -> {
            // Only handle server errors to avoid conflicts with existing error pages
            if (status == HttpStatus.INTERNAL_SERVER_ERROR) {
                ModelAndView mav = new ModelAndView("error/500");
                mav.addAllObjects(model);
                // Add the context path for template rendering
                mav.addObject("contextPath", request.getContextPath());
                return mav;
            }
            
            // For 404 errors
            if (status == HttpStatus.NOT_FOUND) {
                ModelAndView mav = new ModelAndView("error/404"); 
                mav.addAllObjects(model);
                mav.addObject("contextPath", request.getContextPath());
                return mav;
            }
            
            // Default error view for other status codes
            return null; // Return null to use the default error view resolution
        };
    }
}