package com.example.webapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

/**
 * Database configuration that provides the appropriate datasource based on the active profile:
 * - dev: HikariCP-based direct connection to local Oracle in Docker
 * - prod: JNDI-based connection from WebLogic server
 */
@Configuration
@Slf4j
public class DatabaseConfig {

    /**
     * For the production environment, configure DataSource from JNDI.
     * This bean will be created only when spring.datasource.jndi-name property is set.
     */
    @Bean
    @Profile("prod")
    @ConditionalOnProperty(name = "spring.datasource.jndi-name")
    public DataSource jndiDataSource(@Value("${spring.datasource.jndi-name}") String jndiName) {
        try {
            log.info("Initializing DataSource from JNDI: {}", jndiName);
            return new JndiTemplate().lookup(jndiName, DataSource.class);
        } catch (NamingException e) {
            log.error("Error looking up JNDI datasource: {}", jndiName, e);
            throw new RuntimeException("Error looking up JNDI datasource: " + jndiName, e);
        }
    }

    /**
     * Configure JdbcTemplate with the injected DataSource
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) throws SQLException {
        // Log connection information for verification
        log.info("Initializing JdbcTemplate with datasource: {}", dataSource.getClass().getName());
        if (log.isDebugEnabled()) {
            try (var connection = dataSource.getConnection()) {
                log.debug("Connected to database: {}", connection.getMetaData().getURL());
            }
        }
        return new JdbcTemplate(dataSource);
    }
}
