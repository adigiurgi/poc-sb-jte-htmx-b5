package com.example.webapp.infrastructure.adapters.out.database.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

/**
 * Simple repository class to verify database connectivity on application startup.
 * This class runs a simple query against the database to confirm the connection works.
 */
@Repository
@Slf4j
public class DatabaseVerificationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseVerificationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Verifies database connectivity once the application has fully started.
     * This method is triggered by the ApplicationReadyEvent.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void verifyDatabaseConnection() {
        try {
            String databaseVersion = jdbcTemplate.queryForObject(
                    "SELECT BANNER FROM V$VERSION WHERE BANNER LIKE 'Oracle%'", String.class);
            log.info("Successfully connected to the database: {}", databaseVersion);
        } catch (Exception e) {
            log.error("Failed to connect to the database", e);
        }
    }
}
