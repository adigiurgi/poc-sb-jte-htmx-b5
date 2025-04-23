package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.dto.command.UserRoleCreateDto;
import com.example.webapp.application.ports.out.database.UserRoleDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserRole;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class UserRoleDaoImplementation implements UserRoleDao {
    private final UserRoleRepository userRoleRepository;

    @Override
    public Long saveUserRole(UserRoleCreateDto userRoleCreateDto) {
        UserRole userRole = UserRole.builder()
                .idUser(userRoleCreateDto.idUser())
                .roleName(userRoleCreateDto.roleName())
                .insertedAt(OffsetDateTime.now())
                .build();

        UserRole savedUserRole = userRoleRepository.save(userRole);
        return savedUserRole.getId();
    }
}
