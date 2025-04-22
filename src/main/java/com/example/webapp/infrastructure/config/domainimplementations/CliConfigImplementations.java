package com.example.webapp.infrastructure.config.domainimplementations;

import com.example.webapp.application.domain.service.cli.UserAppCliApiImplementation;
import com.example.webapp.application.domain.service.cli.UserProfileCliApiImplementation;
import com.example.webapp.application.domain.service.cli.UserRoleCliApiImplementation;
import com.example.webapp.application.ports.in.cli.UserAppCliApi;
import com.example.webapp.application.ports.in.cli.UserProfileCliApi;
import com.example.webapp.application.ports.in.cli.UserRoleCliApi;
import com.example.webapp.application.ports.out.database.UserAppDao;
import com.example.webapp.application.ports.out.database.UserProfileDao;
import com.example.webapp.application.ports.out.database.UserRoleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CliConfigImplementations {

    @Bean
    public UserAppCliApi userAppCliApi(UserAppDao userAppDao) {
        log.info("Creating UserAppCliApi bean");
        return new UserAppCliApiImplementation(userAppDao);
    }

    @Bean
    public UserProfileCliApi userProfileCliApi(UserProfileDao userProfileDao) {
        log.info("Creating UserProfileCliApi bean");
        return new UserProfileCliApiImplementation(userProfileDao);
    }
    
    @Bean
    public UserRoleCliApi userRoleCliApi(UserRoleDao userRoleDao) {
        log.info("Creating UserRoleCliApi bean");
        return new UserRoleCliApiImplementation(userRoleDao);
    }

}
