package com.example.webapp.config;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import gg.jte.resolve.ResourceCodeResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
// import org.springframework.core.Ordered;
// import org.springframework.web.servlet.ViewResolver;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Configurație JTE specifică pentru WebLogic care utilizează șabloane precompilate.
 */
@Slf4j
@Configuration
@Profile("prod")
public class JteWebLogicConfig {

    @Value("${gg.jte.templateLocation:jte}")
    private String templateLocation;

    @Value("${gg.jte.developmentMode:false}")
    private boolean developmentMode;

    @Value("${gg.jte.use-precompiled-templates:true}")
    private boolean usePrecompiledTemplates;

    /**
     * Creează un motor de șabloane JTE care utilizează clasele precompilate în mediul WebLogic.
     */
    @Bean
    public TemplateEngine jteTemplateEngine() {
        log.info("Configurez JTE Template Engine pentru WebLogic cu precompilare: {}", usePrecompiledTemplates);
        
        if (usePrecompiledTemplates) {
            // Folosim clasele precompilate din classpath
            return TemplateEngine.createPrecompiled(ContentType.Html);
        } else if (developmentMode) {
            // Pentru dezvoltare - încărcarea din director fizic
            Path templatePath = Paths.get(templateLocation);
            log.info("Folosind directorul de șabloane: {}", templatePath.toAbsolutePath());
            return TemplateEngine.create(new DirectoryCodeResolver(templatePath), ContentType.Html);
        } else {
            // Încărcarea din classpath
            return TemplateEngine.create(new ResourceCodeResolver(templateLocation), ContentType.Html);
        }
    }

    /**
     * Creează un ViewResolver pentru șabloanele JTE care are prioritate maximă
     */
    // @Bean
    // public ViewResolver jteViewResolver(TemplateEngine templateEngine) {
    //     log.info("Configurez JTE ViewResolver pentru WebLogic");
    //     SpringJteViewResolver viewResolver = new SpringJteViewResolver(templateEngine, SpringJteView.class);
    //     viewResolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
    //     viewResolver.setPrefix("");  // Prefixul este gol pentru că căile sunt deja specificate
    //     viewResolver.setSuffix("");  // Sufixul este gol pentru că extensia este inclusă în numele șablonului
    //     return viewResolver;
    // }
}