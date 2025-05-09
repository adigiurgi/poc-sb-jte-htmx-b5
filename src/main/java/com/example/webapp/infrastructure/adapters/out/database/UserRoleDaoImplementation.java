package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.domain.models.UserRole;
import com.example.webapp.application.dto.command.UserRoleCreateDto;
import com.example.webapp.application.ports.out.database.UserRoleDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserRoleEntity;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

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
    public List<UserRole> findRolesByIdUser(Long idUser) {
        return userRoleRepository.findByIdUser(idUser).stream()
                .map(userRoleEntity -> UserRole.create(userRoleEntity.getIdUser(),
                        userRoleEntity.getRoleName()))
                .filter(userRole -> !userRole.getRoleName().equalsIgnoreCase("WEBAPP_ROLE"))
                .toList();
    }
}
