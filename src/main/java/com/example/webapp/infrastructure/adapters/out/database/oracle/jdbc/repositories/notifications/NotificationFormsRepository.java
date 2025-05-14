package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.notifications;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.notifications.NotificationFormsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationFormsRepository  extends CrudRepository<NotificationFormsEntity, Long> {

    List<NotificationFormsEntity> findByIdProfileAndModuleName(Long idProfile, String moduleName);
    int countByIdProfileAndModuleName(Long idProfile, String moduleName);
//
//    @Query("SELECT count(9) from USER_NOTIFICATIONS_OLD t where t.id_profile=:paramIdProfil and t.module_name=:paramModuleName")
//    int countNotificariDupaProfilSiModul(@Param("paramIdProfil") Long idProfil, @Param("paramModuleName") String moduleName);

}
