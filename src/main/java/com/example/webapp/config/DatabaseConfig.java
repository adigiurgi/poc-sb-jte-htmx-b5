// package com.example.webapp.config;

// import lombok.extern.slf4j.Slf4j;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;

// @Slf4j
// @Configuration
// public class DatabaseConfig {

//     @Configuration
//     @Profile("dev")
//     public static class DevDatabaseConfig {
//         public DevDatabaseConfig() {
//             log.info("Initializing development database configuration");
//             // Dev-specific database configuration can be added here
//         }
//     }

//     @Configuration
//     @Profile("prod")
//     public static class ProdDatabaseConfig {
//         public ProdDatabaseConfig() {
//             log.info("Initializing production database configuration");
//             // Production-specific database configuration can be added here
//         }
//     }
// }