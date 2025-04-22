package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.ports.out.database.UserRoleDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRoleDaoImplementation implements UserRoleDao {
    private final UserRoleRepository userRoleRepository;
}
