package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    List<UserProfile> findByIdUser(Long idUser);
}
