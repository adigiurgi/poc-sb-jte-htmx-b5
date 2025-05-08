package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.domain.models.Notification;
import com.example.webapp.application.ports.out.database.NotificationDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Types;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationDaoImplementation implements NotificationDao {

    private final NotificationRepository notificationRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Notification> getNotificationsByProfileAndModule(Long idProfile, String moduleName) {
        List<Notification> notifications = new ArrayList<>();
        List<Map<String, Object>> results = notificationRepository.findNotificationsByProfileAndModule(idProfile, moduleName);

        for (Map<String, Object> row : results) {
            Notification notification = Notification.create(
                    ((Number) row.get("ID")).longValue(),
                    ((Number) row.get("ID_PROFILE")).longValue(),
                    (String) row.get("MODULE_NAME"),
                    (String) row.get("TIP_MESAJ"),
                    (String) row.get("TEXT_MESAJ"),
                    (OffsetDateTime) row.get("INSERTED_AT"),
                    (OffsetDateTime) row.get("UPDATED_AT")
            );
            notifications.add(notification);
        }

        return notifications;
    }

    @Override
    public long calculateNotificationsForModule(Long idProfile, String moduleName) {
        String procedureName = String.format("WEBAPP.MESAJE_MODUL_%s.verificare_mesaje", moduleName);
        
        long startTime = System.currentTimeMillis();
        
        jdbcTemplate.execute(connection -> {
            CallableStatement cs = connection.prepareCall("{call " + procedureName + "(?)}");
            cs.setLong(1, idProfile);
            return cs;
        });
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        log.info("Procedure {} executed in {} ms", procedureName, executionTime);
        return executionTime;
    }

    @Override
    public int countNotificationsByProfileAndModule(Long idProfile, String moduleName) {
        return notificationRepository.countNotificationsByProfileAndModule(idProfile, moduleName);
    }
}
