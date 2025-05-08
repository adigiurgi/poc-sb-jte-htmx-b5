package com.example.webapp.infrastructure.config.domainimplementations;

import com.example.webapp.application.domain.service.web.NotificationWebApiImplementation;
import com.example.webapp.application.ports.in.web.NotificationWebApi;
import com.example.webapp.application.ports.out.database.NotificationDao;
import com.example.webapp.application.ports.out.database.UserRoleDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebApiConfigImplementations {
    
    @Bean
    public NotificationWebApi notificationWebApi(NotificationDao notificationDao, UserRoleDao userRoleDao) {
        return new NotificationWebApiImplementation(notificationDao, userRoleDao);
    }
}
