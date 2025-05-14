package com.example.webapp.infrastructure.adapters.out.database.users;

import com.example.webapp.application.domain.models.users.UserApp;
import com.example.webapp.application.ports.out.database.users.UserAppDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.users.UserAppEntity;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.users.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class UserAppDaoImplementation implements UserAppDao {
    private final UserAppRepository userAppRepository;

    @Override
    public Long saveUser(UserApp userApp) {
        UserAppEntity userAppEntity = UserAppEntity.builder()
                .username(userApp.getUsername())
                .firstName(userApp.getFirstName())
                .lastName(userApp.getLastName())
                .insertedAt(OffsetDateTime.now())
                .build();
        UserAppEntity savedUserAppEntity = userAppRepository.save(userAppEntity);
        return savedUserAppEntity.getId();
    }
}
