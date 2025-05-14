package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.notifications;

import com.example.webapp.infrastructure.config.database.SetDatabaseContextForMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class NotificationsFormsProcedureRepository {

    private final SimpleJdbcCall procedureModulA;
    private final SimpleJdbcCall procedureModulB;
    private final SimpleJdbcCall procedureModulC;
    private final SimpleJdbcCall procedureModulD;

    public NotificationsFormsProcedureRepository(JdbcTemplate jdbcTemplate) {

        // Configurăm apelul procedurii stocate
        this.procedureModulA = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("WEBAPP") // Înlocuiți cu numele schemei dvs.
                .withCatalogName("MESAJE_MODUL_A")
                .withProcedureName("VERIFICARE_MESAJE");

        this.procedureModulB = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("WEBAPP") // Înlocuiți cu numele schemei dvs.
                .withCatalogName("MESAJE_MODUL_B")
                .withProcedureName("VERIFICARE_MESAJE");

        this.procedureModulC = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("WEBAPP") // Înlocuiți cu numele schemei dvs.
                .withCatalogName("MESAJE_MODUL_C")
                .withProcedureName("VERIFICARE_MESAJE");

        this.procedureModulD = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("WEBAPP") // Înlocuiți cu numele schemei dvs.
                .withCatalogName("MESAJE_MODUL_D")
                .withProcedureName("VERIFICARE_MESAJE");

    }

    @SetDatabaseContextForMethod(
            procedureName = "set_connection_context",
            parameterName = "p_username"
    )
    public void processNotificationsForModuleA(String username){
        log.info("Procesam notificarile pentru modulul A pentru utilizatorul {}", username);
        procedureModulA.execute();
    }

    @SetDatabaseContextForMethod(
            procedureName = "set_connection_context",
            parameterName = "p_username"
    )
    public void processNotificationsForModuleB(String username){
        log.info("Procesam notificarile pentru modulul B pentru utilizatorul {}", username);
        procedureModulB.execute();
    }

    @SetDatabaseContextForMethod(
            procedureName = "set_connection_context",
            parameterName = "p_username"
    )
    public void processNotificationsForModuleC(String username){
        log.info("Procesam notificarile pentru modulul C pentru utilizatorul {}", username);
        procedureModulC.execute();
    }

    @SetDatabaseContextForMethod(
            procedureName = "set_connection_context",
            parameterName = "p_username"
    )
    public void processNotificationsForModuleD(String username){
        log.info("Procesam notificarile pentru modulul D pentru utilizatorul {}", username);
        procedureModulD.execute();
    }
}
