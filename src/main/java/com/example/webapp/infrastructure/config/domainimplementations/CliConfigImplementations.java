package com.example.webapp.infrastructure.config.domainimplementations;

import com.example.webapp.application.domain.service.cli.UserAppApiImplementation;
import com.example.webapp.application.domain.service.cli.UserProfileApiImplementation;
import com.example.webapp.application.ports.in.cli.UserAppApi;
import com.example.webapp.application.ports.in.cli.UserProfileApi;
import com.example.webapp.application.ports.out.database.UserAppDao;
import com.example.webapp.application.ports.out.database.UserProfileDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CliConfigImplementations {

    @Bean
    public UserAppApi userAppApi(UserAppDao userAppDao) {
        log.info("Creating UserAppApi bean");
        return new UserAppApiImplementation(userAppDao);
    }

    @Bean
    public UserProfileApi userProfileApi(UserProfileDao userProfileDao) {
        return new UserProfileApiImplementation(userProfileDao);
    }

}
