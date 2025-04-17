package com.example.webapp.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Configuration class to enable aspect-oriented programming (AOP) features.
 * This is required for the DatabaseContextAspect to function properly.
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    // No additional beans needed here - @EnableAspectJAutoProxy does the work
}
