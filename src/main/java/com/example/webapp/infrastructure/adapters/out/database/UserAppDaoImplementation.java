package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.ports.out.database.UserAppDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAppDaoImplementation implements UserAppDao {
    private final UserAppRepository userAppRepository;
}
