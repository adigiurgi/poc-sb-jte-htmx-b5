package com.example.webapp.infrastructure.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Web security configuration for the application.
 * Different configurations apply based on active profiles.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Security configuration for development environments
     */
    @Bean
    @Profile({"dev", "local"})
    public SecurityFilterChain devSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // for simplicity in dev
            .authorizeRequests()
                .antMatchers("/error/**", "/css/**", "/js/**", "/static/**").permitAll()
                .anyRequest().permitAll(); // Trust our custom filter in dev
        
        return http.build();
    }

    /**
     * Security configuration for production and test environments
     */
    @Bean
    @Profile({"prod", "test"})
    public SecurityFilterChain prodSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/error/**", "/css/**", "/js/**", "/static/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .exceptionHandling()
                .accessDeniedPage("/error/access-denied");
                
        // In production, we rely on the container's authentication (e.g., WebLogic)
        // The remote user will be available via request.getRemoteUser()
        
        return http.build();
    }
}
