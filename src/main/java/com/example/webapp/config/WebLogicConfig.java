package com.example.webapp.config;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Profile("prod")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class WebLogicConfig {
    
    /**
     * Dezactivează ErrorPageFilter al Spring Boot atunci când rulează în WebLogic
     * pentru a preveni conflictele cu mecanismele proprii de gestionare a erorilor ale WebLogic.
     * Acest lucru rezolvă NullPointerException în ServletResponseImpl.sendContentError
     */
    @Bean
    public FilterRegistrationBean<ErrorPageFilter> disableSpringBootErrorFilter() {
        log.info("Dezactivez Spring Boot ErrorPageFilter pentru compatibilitate cu WebLogic");
        FilterRegistrationBean<ErrorPageFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new ErrorPageFilter());
        registration.setEnabled(false);
        return registration;
    }
    
    /**
     * Opțional - dacă avem nevoie de setări specifice pentru caracterele utilizate
     */
    @Bean
    public FilterRegistrationBean<org.springframework.web.filter.CharacterEncodingFilter> characterEncodingFilterRegistration() {
        log.info("Configurez filtrul de codificare UTF-8 pentru WebLogic");
        org.springframework.web.filter.CharacterEncodingFilter filter = new org.springframework.web.filter.CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        
        FilterRegistrationBean<org.springframework.web.filter.CharacterEncodingFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(filter);
        registration.addUrlPatterns("/*");
        registration.setName("characterEncodingFilter");
        registration.setOrder(1);
        return registration;
    }
}