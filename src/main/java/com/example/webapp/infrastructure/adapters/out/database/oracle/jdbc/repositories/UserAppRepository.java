package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends CrudRepository<UserApp, Long> {
    Optional<UserApp> findByUsername(String username);
}
