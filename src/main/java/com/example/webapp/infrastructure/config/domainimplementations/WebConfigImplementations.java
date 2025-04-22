package com.example.webapp.infrastructure.config.domainimplementations;

import com.example.webapp.application.domain.service.web.UserActiveProfileWebApiImplementation;
import com.example.webapp.application.ports.in.web.UserActiveProfileWebApi;
import com.example.webapp.application.ports.out.database.UserActiveProfileDao;
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
}
