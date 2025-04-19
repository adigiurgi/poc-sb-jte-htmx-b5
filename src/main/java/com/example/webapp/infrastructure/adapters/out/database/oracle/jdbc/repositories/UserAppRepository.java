package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserAppRepository extends CrudRepository<UserApp, Long> {
    Optional<UserApp> findById(Long idUser);
    // Interogări derivate din numele metodei

    Optional<UserApp> findByUsername(String username);
/*
    List<UserApp> findByFirstName(String firstName);

    List<UserApp> findByLastName(String lastName);

    List<UserApp> findByFirstNameAndLastName(String firstName, String lastName);

    List<UserApp> findByFirstNameOrLastName(String firstName, String lastName);

    boolean existsByUsername(String username);

    long countByFirstName(String firstName);

    List<UserApp> findByFirstNameLike(String firstName); // Similar cu operatorul LIKE din SQL

    List<UserApp> findByLastNameStartingWith(String prefix); // Găsește utilizatorii al căror nume începe cu prefixul dat

    List<UserApp> findByOrderByLastNameAsc(); // Ordonează rezultatele după nume

    List<UserApp> findTop3ByOrderByFirstNameAsc(); // Returnează primii 3 utilizatori ordonați după prenume

 */
}
