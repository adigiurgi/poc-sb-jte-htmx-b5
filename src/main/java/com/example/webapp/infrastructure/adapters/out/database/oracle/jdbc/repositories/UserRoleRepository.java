package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    List<UserRole> findByIdUser(Long idUser);
}
