package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.dto.command.UserRoleCreateDto;
import com.example.webapp.application.ports.out.database.UserRoleDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserRole;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UserRoleDaoImplementation implements UserRoleDao {
    private final UserRoleRepository userRoleRepository;

    @Override
    public Long saveUserRole(UserRoleCreateDto userRoleCreateDto) {
        UserRole userRole = new UserRole(
                null,
                userRoleCreateDto.idUser(),
                userRoleCreateDto.roleName(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                0
        );
        
        UserRole savedUserRole = userRoleRepository.save(userRole);
        return savedUserRole.id();
    }
}
