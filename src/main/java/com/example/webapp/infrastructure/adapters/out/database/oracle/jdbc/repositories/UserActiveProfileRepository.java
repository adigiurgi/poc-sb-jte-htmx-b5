package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserActiveProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserActiveProfileRepository extends CrudRepository<UserActiveProfile, Long> {

    Optional<UserActiveProfile> findByUsername(String username);

}
