package com.example.webapp.infrastructure.config.domainimplementations;

import com.example.webapp.application.domain.service.web.UserActiveProfileWebApiImplementation;
import com.example.webapp.application.domain.service.web.NotificationFormsApiImplem;
import com.example.webapp.application.domain.service.web.UserProfileWebApiImplementation;
import com.example.webapp.application.ports.in.web.UserActiveProfileWebApi;
import com.example.webapp.application.ports.in.web.NotificationFormsApi;
import com.example.webapp.application.ports.in.web.UserProfileWebApi;
import com.example.webapp.application.ports.out.database.NotificationFormsDao;
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
    public NotificationFormsApi userFormsNotificationsApi(UserRoleDao userRoleDao,
                                                          NotificationFormsDao notificationFormsDao) {
        log.info("Creating UserFormsNotificationsApi bean");
        return new NotificationFormsApiImplem(userRoleDao, notificationFormsDao);
    }
}
