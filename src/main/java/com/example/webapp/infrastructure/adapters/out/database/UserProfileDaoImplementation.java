package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.ports.out.database.UserProfileDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileDaoImplementation implements UserProfileDao {

     private final UserProfileRepository userProfileAppRepository;

}
