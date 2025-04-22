package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.domain.models.User;
import com.example.webapp.application.ports.out.database.UserAppDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserApp;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UserAppDaoImplementation implements UserAppDao {
    private final UserAppRepository userAppRepository;

    @Override
    public Long saveUser(User user) {
        UserApp userApp = new UserApp(
                null,
                user.username(),
                user.firstName(),
                user.lastName(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                0
        );
        
        UserApp savedUserApp = userAppRepository.save(userApp);
        return savedUserApp.id();
    }
}
