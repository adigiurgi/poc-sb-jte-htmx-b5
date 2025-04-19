package com.example.webapp.infrastructure.config.domainimplementations;

import com.example.webapp.application.domain.service.web.UserActiveProfileApiImplementation;
import com.example.webapp.application.ports.in.web.UserActiveProfileApi;
import com.example.webapp.application.ports.out.database.UserActiveProfileDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class WebConfigImplementations {

    @Bean
    public UserActiveProfileApi userActiveProfileApi(UserActiveProfileDao userActiveProfileDao) {
        return new UserActiveProfileApiImplementation(userActiveProfileDao);
    }
}
