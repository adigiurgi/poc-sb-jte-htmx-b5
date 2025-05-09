package com.example.webapp.infrastructure.config.domainimplementations;

import com.example.webapp.application.domain.service.web.UserActiveProfileWebApiImplementation;
import com.example.webapp.application.domain.service.web.UserFormsNotificationsApiImplem;
import com.example.webapp.application.domain.service.web.UserProfileWebApiImplementation;
import com.example.webapp.application.ports.in.web.UserActiveProfileWebApi;
import com.example.webapp.application.ports.in.web.UserFormsNotificationsApi;
import com.example.webapp.application.ports.in.web.UserProfileWebApi;
import com.example.webapp.application.ports.out.database.UserActiveProfileDao;
import com.example.webapp.application.ports.out.database.UserProfileDao;
import com.example.webapp.application.ports.out.database.UserRoleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class WebConfigImplementations {

    @Bean
    public UserActiveProfileWebApi userActiveProfileWebApi(UserActiveProfileDao userActiveProfileDao) {
        log.info("Creating UserActiveProfileWebApi bean");
        return new UserActiveProfileWebApiImplementation(userActiveProfileDao);
    }

    @Bean
    public UserProfileWebApi userProfileWebApi(UserProfileDao userProfileDao) {
        log.info("Creating UserProfileWebApi bean");
        return new UserProfileWebApiImplementation(userProfileDao);
    }

    @Bean
    public UserFormsNotificationsApi userFormsNotificationsApi(UserRoleDao userRoleDao) {
        log.info("Creating UserFormsNotificationsApi bean");
        return new UserFormsNotificationsApiImplem(userRoleDao);
    }
}
