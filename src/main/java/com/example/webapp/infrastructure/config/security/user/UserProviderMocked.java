package com.example.webapp.infrastructure.config.security.user;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev","local"})
public class UserProviderMocked implements UserProvider {
    @Override
    /*
        We will return here whatever user we want to test the app with in our development process (on the "dev" or "local" profile)
    */
    public String getAuthenticatedUser() {
        return "john.doe";

    }
}
