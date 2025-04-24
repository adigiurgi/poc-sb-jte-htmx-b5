package com.example.webapp.infrastructure.config.security.user;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Profile({"test","prod"})
public class UserProviderSso implements UserProvider {
    @Override
    public String getAuthenticatedUser() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes != null) {
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
            return httpServletRequest.getRemoteUser().toUpperCase();
        }
        //TODO to think about maybe throwing specific error or redirect to some error page instead of returning null
        return null;
    }
}
