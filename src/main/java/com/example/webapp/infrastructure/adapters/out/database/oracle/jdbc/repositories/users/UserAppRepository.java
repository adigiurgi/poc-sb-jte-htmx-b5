package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.users;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.users.UserAppEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends CrudRepository<UserAppEntity, Long> {
    Optional<UserAppEntity> findByUsername(String username);
}
