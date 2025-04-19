package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.ports.out.database.UserActiveProfileDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserActiveProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserActiveProfileDaoImplementation implements UserActiveProfileDao {
    private final UserActiveProfileRepository userActiveProfileRepository;
}
