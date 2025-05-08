package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long> {
    List<UserRoleEntity> findByIdUser(Long idUser);
    
    /**
     * Check if a user has a specific role
     * 
     * @param idUser The user ID
     * @param roleName The role name
     * @return true if the user has the specified role
     */
    boolean existsByIdUserAndRoleName(Long idUser, String roleName);
}
