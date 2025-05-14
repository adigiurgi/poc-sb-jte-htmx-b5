package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.users;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.users.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfileEntity, Long> {
    List<UserProfileEntity> findByIdUser(Long idUser);
}
