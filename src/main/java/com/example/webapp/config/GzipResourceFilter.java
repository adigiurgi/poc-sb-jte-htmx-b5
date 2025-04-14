package com.example.webapp.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filtru care setează corect header-ul Content-Encoding: gzip
 * pentru resursele comprimate servite prin GzipResourceResolver
 */
public class GzipResourceFilter extends OncePerRequestFilter {    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                   FilterChain filterChain) throws ServletException, IOException {
        
        GzipHttpServletResponseWrapper wrappedResponse = new GzipHttpServletResponseWrapper(response);
        wrappedResponse.setRequest(request);  // Setăm request-ul în wrapper pentru a-l putea folosi
        filterChain.doFilter(request, wrappedResponse);
    }
    
    /**
     * Wrapper pentru HttpServletResponse care detectează dacă resursa servită este un fișier .gz
     * și setează header-ul Content-Encoding corespunzător
     */    private static class GzipHttpServletResponseWrapper extends javax.servlet.http.HttpServletResponseWrapper {
        
        public GzipHttpServletResponseWrapper(HttpServletResponse response) {
            super(response);
        }
          private HttpServletRequest request;
        
        // Adăugăm o metodă pentru a seta request-ul asociat
        public void setRequest(HttpServletRequest request) {
            this.request = request;
        }
        
        @Override
        public void setContentType(String contentType) {
            // Folosim request-ul stocat ca field
            if (request == null) {
                // Nu putem aplica logica pentru gzip dacă nu avem request
                super.setContentType(contentType);
                return;
            }
            
            String requestURI = request.getRequestURI();
            
            // Verificăm dacă servim un fișier .gz
            boolean isGzipped = requestURI.endsWith(".gz") || Boolean.TRUE.equals(request.getAttribute("gzipped"));
            
            if (isGzipped) {
                // Setăm Content-Encoding: gzip
                setHeader("Content-Encoding", "gzip");
                
                // Corectăm content-type-ul pentru fișierele .gz
                if (contentType != null) {
                    if (contentType.contains(".gz")) {
                        // Eliminăm extensia .gz din Content-Type
                        contentType = contentType.replace(".gz", "");
                    }
                    
                    // Asigurăm că folosim tipul MIME corect pentru CSS și JS
                    if (requestURI.endsWith(".css.gz")) {
                        contentType = "text/css";
                    } else if (requestURI.endsWith(".js.gz")) {
                        contentType = "application/javascript";
                    }
                }
            }
            
            // Setăm content type-ul (posibil corectat)
            super.setContentType(contentType);
        }
        
        private boolean isVendorResource(String uri) {
            return uri.contains("/vendor/");
        }
        
        private boolean isJsResource(String uri) {
            return uri.endsWith(".js") || uri.endsWith(".js.gz");
        }
        
        private boolean isCssResource(String uri) {
            return uri.endsWith(".css") || uri.endsWith(".css.gz");
        }
        
        private boolean isGzipSupported(HttpServletRequest request) {
            String acceptEncoding = request.getHeader("Accept-Encoding");
            return acceptEncoding != null && acceptEncoding.toLowerCase().contains("gzip");
        }
    }
}
