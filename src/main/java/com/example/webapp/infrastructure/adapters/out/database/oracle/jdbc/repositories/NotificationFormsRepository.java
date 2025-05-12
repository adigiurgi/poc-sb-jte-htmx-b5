package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.NotificationForms;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationFormsRepository  extends CrudRepository<NotificationForms, Long> {

    List<NotificationForms> findByIdProfileAndModuleName(Long idProfile, String moduleName);
    int countByIdProfileAndModuleName(Long idProfile, String moduleName);
//
//    @Query("SELECT count(9) from USER_NOTIFICATIONS_OLD t where t.id_profile=:paramIdProfil and t.module_name=:paramModuleName")
//    int countNotificariDupaProfilSiModul(@Param("paramIdProfil") Long idProfil, @Param("paramModuleName") String moduleName);

}
