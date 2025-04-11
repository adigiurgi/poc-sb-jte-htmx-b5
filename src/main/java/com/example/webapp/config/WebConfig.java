package com.example.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // Configurare JTE este gestionată automat de jte-spring-boot-starter-3
    // Nu mai este nevoie de configurarea manuală a ViewResolver-ului
    
    @SuppressWarnings("null")
@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configurare pentru resurse CSS
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/");
        
        // Configurare pentru resurse JavaScript
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/js/");
        
        // Configurare pentru alte resurse statice (imagini, fonturi, etc.)
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
