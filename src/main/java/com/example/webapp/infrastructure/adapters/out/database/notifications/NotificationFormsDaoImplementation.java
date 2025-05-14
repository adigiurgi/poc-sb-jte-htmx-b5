package com.example.webapp.infrastructure.adapters.out.database.notifications;

import com.example.webapp.application.domain.models.notifications.forms.NotificationForms;
import com.example.webapp.application.ports.out.database.notifications.NotificationFormsDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.notifications.NotificationFormsRepository;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.notifications.NotificationsFormsProcedureRepository;
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
        switch (moduleName) {
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
        return notificationFormsRepository.countByIdProfileAndModuleName(idProfile, moduleName);
    }

    @Override
    public List<NotificationForms> getNotificationFormsByProfileAndModule(Long idProfile, String moduleName) {
        return notificationFormsRepository.findByIdProfileAndModuleName(idProfile, moduleName)
                .stream()
                .map(notificationFormsEntity ->
                        NotificationForms.create(notificationFormsEntity.getId(),
                                notificationFormsEntity.getIdProfile(),
                                notificationFormsEntity.getModuleName(),
                                notificationFormsEntity.getTipMesaj(),
                                notificationFormsEntity.getTextMesaj())).
                toList();
    }
}
