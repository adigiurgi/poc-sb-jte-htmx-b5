package com.example.webapp.infrastructure.config;

import com.example.webapp.infrastructure.config.security.SecurityInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    // Configurare JTE este gestionată automat de jte-spring-boot-starter-3
    // Nu mai este nevoie de configurarea manuală a ViewResolver-ului
    
    @Autowired
    private Environment environment;

    private final SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor)
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**");
    }

    /**
     * Înregistrăm filtrul pentru servirea fișierelor comprimate,
     * doar în profilul de producție
     */
    @Bean
    @Profile({"prod", "test", "local"})
    public FilterRegistrationBean<GzipResourceFilter> gzipResourceFilterRegistration() {
        FilterRegistrationBean<GzipResourceFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new GzipResourceFilter());
        registration.addUrlPatterns("/css/vendor/*", "/js/vendor/*");
        registration.setName("gzipResourceFilter");
        registration.setOrder(1);
        System.out.println("GzipResourceFilter a fost înregistrat pentru profilul de producție.");
        return registration;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        boolean isWebLogicProfile = isWebLogicProfile();
        
        // Configurare pentru resurse CSS
        configureResourceHandler(registry, "/css/vendor/**", "classpath:/css/vendor/", isWebLogicProfile);
        
        // Resurse CSS custom nu sunt comprimate
        registry.addResourceHandler("/css/custom/**")
                .addResourceLocations("classpath:/css/custom/");
        
        // Configurare pentru resurse JavaScript
        configureResourceHandler(registry, "/js/vendor/**", "classpath:/js/vendor/", isWebLogicProfile);
        
        // Resurse JS custom nu sunt comprimate
        registry.addResourceHandler("/js/custom/**")
                .addResourceLocations("classpath:/js/custom/");
        
        // Configurare pentru alte resurse statice (imagini, fonturi, etc.)
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
    
    /**
     * Configurează un resource handler cu suport opțional pentru gzip, doar pentru profilul de producție
     */
    private void configureResourceHandler(ResourceHandlerRegistry registry, 
                                         String pathPattern, 
                                         String location, 
                                         boolean withGzipSupport) {
        if (withGzipSupport) {
            // În producție, adăugăm două handler-uri separate:
            
            // 1. Un handler pentru fișierele .gz care le servește direct
            registry.addResourceHandler(pathPattern + "*.gz")
                    .addResourceLocations(location)
                    .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
            
            // 2. Un handler normal care poate folosi GzipResourceResolver pentru a servi
            // fie fisierul normal, fie varianta .gz in functie de suportul browserului
            registry.addResourceHandler(pathPattern)
                    .addResourceLocations(location)
                    .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
                    .resourceChain(true)
                    .addResolver(new GzipResourceResolver())
                    .addResolver(new EncodedResourceResolver())
                    .addResolver(new PathResourceResolver());
            System.out.println("Handler pentru " + pathPattern + " a fost configurat cu suport gzip.");
        } else {
            // În dev, fără compresie și fără cache
            registry.addResourceHandler(pathPattern)
                    .addResourceLocations(location);
        }
    }
    
    /**
     * Verifică dacă profilul activ este "prod"
     */
    private boolean isWebLogicProfile() {
        for (String profile : environment.getActiveProfiles()) {
            if ("prod".equals(profile) || "test".equals(profile) || "local".equals(profile)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // Configurăm tipurile MIME pentru fișierele .gz
        configurer.mediaType("css.gz", MediaType.valueOf("text/css"));
        configurer.mediaType("js.gz", MediaType.valueOf("application/javascript"));
    }
}
