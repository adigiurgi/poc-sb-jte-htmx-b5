package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.domain.models.notifications.forms.NotificationFormsForModuleDetails;
import com.example.webapp.application.ports.out.database.NotificationFormsDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.NotificationFormsRepository;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.NotificationsFormsProcedureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NotificationFormsDaoImplementation implements NotificationFormsDao {

    private final NotificationsFormsProcedureRepository notificationsFormsProcedureRepository;

    private final NotificationFormsRepository notificationFormsRepository;

    @Override
    public void calculateNotificationsForModule(String username, String moduleName) {
        switch(moduleName) {
            case "MODUL-A" -> {
                notificationsFormsProcedureRepository.processNotificationsForModuleA(username);
            }
            case "MODUL-B" -> {
                notificationsFormsProcedureRepository.processNotificationsForModuleB(username);
            }
            case "MODUL-C" -> {
                notificationsFormsProcedureRepository.processNotificationsForModuleC(username);
            }
            case "MODUL-D" -> {
                notificationsFormsProcedureRepository.processNotificationsForModuleD(username);
            }
            default -> {
                throw new RuntimeException("Nu exista definita nici o procedura pentru verificarea mesajelor aferente acestui modul!");
            }
        }

    }

    @Override
    public int countNotificationsByProfileAndModule(Long idProfile, String moduleName) {
        return notificationFormsRepository.countByIdProfileAndModuleName(idProfile,moduleName);
    }

    @Override
    public List<NotificationFormsForModuleDetails> getNotificationsByProfileAndModule(Long idProfile, String moduleName) {
        return null;
    }
}
