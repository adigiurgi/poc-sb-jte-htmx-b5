package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.users;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.users.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long> {
    List<UserRoleEntity> findByIdUser(Long idUser);
}
