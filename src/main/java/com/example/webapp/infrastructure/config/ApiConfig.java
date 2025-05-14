package com.example.webapp.infrastructure.config;

import com.example.webapp.application.domain.service.notifications.NotificationFormsApiImplem;
import com.example.webapp.application.domain.service.users.UserAdministrationApiImplementation;
import com.example.webapp.application.domain.service.users.UserSessionApiImplementation;
import com.example.webapp.application.ports.in.notifications.NotificationFormsApi;
import com.example.webapp.application.ports.in.users.UserAdministrationApi;
import com.example.webapp.application.ports.in.users.UserSessionApi;
import com.example.webapp.application.ports.out.database.notifications.NotificationFormsDao;
import com.example.webapp.application.ports.out.database.users.UserAppDao;
import com.example.webapp.application.ports.out.database.users.UserProfileDao;
import com.example.webapp.application.ports.out.database.users.UserRoleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ApiConfig {

    @Bean
    public UserSessionApi userSessionApi(UserProfileDao userProfileDao) {
        log.info("Creating UserSessionApi bean");
        return new UserSessionApiImplementation(userProfileDao);
    }

    @Bean
    public UserAdministrationApi userAdministrationApi(UserAppDao userAppDao, UserProfileDao userProfileDao,
                                                       UserRoleDao userRoleDao) {
        log.info("Creating UserAdministrationApi bean");
        return new UserAdministrationApiImplementation(userAppDao, userProfileDao, userRoleDao);
    }

    @Bean
    public NotificationFormsApi userFormsNotificationsApi(UserRoleDao userRoleDao,
                                                          NotificationFormsDao notificationFormsDao) {
        log.info("Creating UserFormsNotificationsApi bean");
        return new NotificationFormsApiImplem(userRoleDao, notificationFormsDao);
    }
}
