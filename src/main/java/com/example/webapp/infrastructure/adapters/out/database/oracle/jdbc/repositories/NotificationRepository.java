package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface NotificationRepository extends Repository<Object, Long> {

    /**
     * Count notifications for a specific profile and module
     * 
     * @param idProfile The profile ID
     * @param moduleName The name of the module
     * @return The number of notifications
     */
    @Query("SELECT COUNT(*) FROM webapp.user_notifications_old " +
            "WHERE id_profile = :idProfile AND " +
            "module_name = :moduleName")
    int countNotificationsByProfileAndModule(@Param("idProfile") Long idProfile, @Param("moduleName") String moduleName);
    
    /**
     * Get all notifications for a specific profile and module
     * 
     * @param idProfile The profile ID
     * @param moduleName The name of the module
     * @return List of notifications as maps
     */
    @Query("SELECT id, id_profile, module_name, tip_mesaj, text_mesaj, inserted_at, updated_at " +
            "FROM webapp.user_notifications_old " +
            "WHERE id_profile = :idProfile AND " +
            "module_name = :moduleName " +
            "ORDER BY inserted_at DESC")
    List<Map<String, Object>> findNotificationsByProfileAndModule(@Param("idProfile") Long idProfile, @Param("moduleName") String moduleName);
}
