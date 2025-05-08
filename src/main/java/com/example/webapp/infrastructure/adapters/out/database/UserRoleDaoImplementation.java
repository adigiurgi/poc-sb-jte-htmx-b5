package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.domain.models.UserRole;
import com.example.webapp.application.dto.command.UserRoleCreateDto;
import com.example.webapp.application.ports.out.database.UserRoleDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserRoleEntity;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRoleDaoImplementation implements UserRoleDao {
    private final UserRoleRepository userRoleRepository;

    @Override
    public Long saveUserRole(UserRole userRole) {
        UserRoleEntity userRoleEntity = UserRoleEntity.builder()
                .idUser(userRole.getIdUser())
                .roleName(userRole.getRoleName())
                .insertedAt(OffsetDateTime.now())
                .build();

        UserRoleEntity savedUserRoleEntity = userRoleRepository.save(userRoleEntity);
        return savedUserRoleEntity.getId();
    }
    
    @Override
    public boolean hasRole(Long idUser, String roleName) {
        log.debug("Checking if user ID {} has role {}", idUser, roleName);
        return userRoleRepository.existsByIdUserAndRoleName(idUser, roleName);
    }
}
