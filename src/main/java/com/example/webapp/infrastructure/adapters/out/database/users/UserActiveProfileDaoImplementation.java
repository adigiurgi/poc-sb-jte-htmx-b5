package com.example.webapp.infrastructure.adapters.out.database.users;

import com.example.webapp.application.ports.out.database.users.UserActiveProfileDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.users.UserActiveProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserActiveProfileDaoImplementation implements UserActiveProfileDao {

    private final UserActiveProfileRepository userActiveProfileRepository;

//    @Override
//    public Optional<UserActiveProfile> findByUsername(String username) {
//        return userActiveProfileRepository.findByUsername(username);
//    }
}
