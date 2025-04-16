package com.example.webapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * ResourceResolver personalizat care servește fișiere .gz pre-comprimate
 * pentru resursele statice din directoarele vendor.
 */
public class GzipResourceResolver implements ResourceResolver {
    
    private static final Logger logger = LoggerFactory.getLogger(GzipResourceResolver.class);

    @Override
    public Resource resolveResource(HttpServletRequest request, String requestPath, 
            List<? extends Resource> locations, ResourceResolverChain chain) {
        
        // Prima încercare - folosim chain-ul normal pentru a încerca să găsim resursa așa cum este
        Resource original = chain.resolveResource(request, requestPath, locations);
        
        // Dacă resursa originală există, o returnăm
        if (original != null) {
            return original;
        }
        
        // Verificăm dacă browserul acceptă gzip și dacă este tipul de resursă care se poate comprima
        if (acceptsGzip(request) && isCompressibleResource(requestPath)) {
            // Formăm calea cu extensia .gz
            String gzippedPath = requestPath;
            if (!gzippedPath.endsWith(".gz")) {
                gzippedPath = gzippedPath + ".gz";
            }
            System.out.println("Încercăm să servim resursa comprimată: " + gzippedPath);
            logger.debug("Încercăm să servim resursa comprimată: {}", gzippedPath);
            
            // Căutăm resursa comprimată
            Resource gzipped = null;
            try {
                // Încercăm mai întâi prin lanțul normal
                gzipped = chain.resolveResource(request, gzippedPath, locations);
                
                // Dacă nu am găsit-o, încercăm direct prin locații
                if (gzipped == null) {
                    for (Resource location : locations) {
                        try {
                            Resource candidate = location.createRelative(gzippedPath);
                            if (candidate.exists() && candidate.isReadable()) {
                                System.out.println("Resursa comprimată găsită direct din locatia: " + candidate.getURL());
                                gzipped = candidate;
                                break;
                            }
                        } catch (IOException e) {
                            System.out.println("Eroare la accesarea resursei comprimate: " + e.getMessage());
                            logger.debug("Eroare la accesarea resursei comprimate: {}", e.getMessage());
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Eroare la rezolvarea resursei comprimate: " + e.getMessage());
                logger.error("Eroare la rezolvarea resursei comprimate: {}", e.getMessage());
            }
            
            if (gzipped != null) {
                System.out.println("S-a găsit varianta comprimată pentru: " + requestPath);
                logger.debug("S-a găsit varianta comprimată pentru: {}", requestPath);
                
                // Setăm atributele pentru a indica că aceasta este o resursă comprimată
                request.setAttribute("gzipped", Boolean.TRUE);
                
                return gzipped;
            }
        }
        
        return null;
    }

    @Override
    public String resolveUrlPath(String resourcePath, List<? extends Resource> locations, ResourceResolverChain chain) {
        // Păstrăm URL-ul original, nu adăugăm .gz la calea URL pentru browser
        return chain.resolveUrlPath(resourcePath, locations);
    }
    
    private boolean acceptsGzip(HttpServletRequest request) {
        String acceptEncoding = request.getHeader("Accept-Encoding");
        return acceptEncoding != null && acceptEncoding.toLowerCase().contains("gzip");
    }
    
    private boolean isCompressibleResource(String path) {
        // Verificăm dacă resursa este un CSS sau JS din directorul vendor
        return path.contains("/vendor/") && 
              (path.endsWith(".css") || path.endsWith(".js"));
    }
}
