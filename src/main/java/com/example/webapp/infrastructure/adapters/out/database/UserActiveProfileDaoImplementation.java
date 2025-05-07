package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.domain.models.UserActiveProfile;
import com.example.webapp.application.ports.out.database.UserActiveProfileDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserActiveProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserActiveProfileDaoImplementation implements UserActiveProfileDao {

    private final UserActiveProfileRepository userActiveProfileRepository;

//    @Override
//    public Optional<UserActiveProfile> findByUsername(String username) {
//        return userActiveProfileRepository.findByUsername(username);
//    }
}
