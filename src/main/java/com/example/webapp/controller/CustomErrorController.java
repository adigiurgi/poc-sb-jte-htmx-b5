package com.example.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.NestedServletException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * Controller personalizat pentru gestionarea erorilor în mediul WebLogic care evită
 * bucle infinite de redirectare prin generarea directă a răspunsului HTML.
 */
@Slf4j
@Controller
@Profile("prod")
public class CustomErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    /**
     * Gestionează cererile de eroare și returnează direct HTML, evitând redirectările
     * care pot cauza bucle infinite când șabloanele JTE nu sunt disponibile.
     */
    @RequestMapping(value = ERROR_PATH, produces = MediaType.TEXT_HTML_VALUE)
    public void handleError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obținem detaliile despre eroare din atributele cererii
        Object statusObj = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object pathObj = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        Object messageObj = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object exceptionObj = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        
        Integer statusCode = 500; // Valoare implicită
        String path = request.getContextPath();
        String message = "A apărut o eroare internă de server";
        String timestamp = new Date().toString();
        String errorTitle = "Eroare de Server";
        
        // Procesăm codul de stare
        if (statusObj != null) {
            statusCode = Integer.parseInt(statusObj.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                errorTitle = "Pagină Negăsită";
                message = "Ne pare rău, pagina solicitată nu există.";
            }
        }
        
        // Procesăm calea URL
        if (pathObj != null) {
            path = pathObj.toString();
        }
        
        // Procesăm mesajul de eroare
        if (messageObj != null && !messageObj.toString().isEmpty()) {
            message = messageObj.toString();
        }
        
        // Procesăm excepția
        String stackTrace = "";
        if (exceptionObj != null) {
            Throwable throwable = null;
            if (exceptionObj instanceof Throwable) {
                throwable = (Throwable) exceptionObj;
            } else if (exceptionObj instanceof NestedServletException) {
                throwable = ((NestedServletException) exceptionObj).getRootCause();
            }
            
            if (throwable != null) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                throwable.printStackTrace(pw);
                stackTrace = sw.toString();
                message = throwable.getMessage() != null ? throwable.getMessage() : message;
            }
        }

        // Pentru depanare
        log.error("Eroare gestionată: cod={}, cale={}, mesaj={}", statusCode, path, message);
        
        // Setăm codul de stare HTTP
        response.setStatus(statusCode);
        
        // Construim răspunsul HTML direct
        String htmlResponse = buildErrorHtml(request.getContextPath(), errorTitle, statusCode, path, message, timestamp);
        
        // Setăm tipul de conținut și scriem răspunsul
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(htmlResponse);
    }

    /**
     * Construiește un răspuns HTML simplu pentru pagina de eroare
     */
    private String buildErrorHtml(String contextPath, String errorTitle, int statusCode, String path, String message, String timestamp) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n")
            .append("<html lang=\"ro\">\n")
            .append("<head>\n")
            .append("    <meta charset=\"UTF-8\">\n")
            .append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n")
            .append("    <title>").append(statusCode).append(" - ").append(errorTitle).append("</title>\n")
            .append("    <link rel=\"stylesheet\" href=\"").append(contextPath).append("/css/vendor/bootstrap/bootstrap.min-5.3.5.css\">\n")
            .append("    <style>\n")
            .append("        body { display: flex; align-items: center; justify-content: center; height: 100vh; background-color: #f8f9fa; }\n")
            .append("        .error-container { text-align: center; padding: 2rem; border-radius: 0.5rem; background-color: white; box-shadow: 0 0.5rem 1rem rgba(0,0,0,0.15); max-width: 600px; }\n")
            .append("        .error-code { font-size: 5rem; font-weight: bold; color: #dc3545; }\n")
            .append("    </style>\n")
            .append("</head>\n")
            .append("<body>\n")
            .append("    <div class=\"container\">\n")
            .append("        <div class=\"error-container\">\n")
            .append("            <div class=\"error-code\">").append(statusCode).append("</div>\n")
            .append("            <h1 class=\"mt-3\">").append(errorTitle).append("</h1>\n")
            .append("            <p class=\"lead\">").append(message).append("</p>\n")
            .append("            <p>URL solicitat: ").append(path).append("</p>\n")
            .append("            <hr>\n")
            .append("            <a href=\"").append(contextPath).append("/\" class=\"btn btn-primary\">Înapoi la pagina principală</a>\n")
            .append("        </div>\n")
            .append("    </div>\n")
            .append("    <script src=\"").append(contextPath).append("/js/vendor/bootstrap/bootstrap.bundle.min-5.3.5.js\"></script>\n")
            .append("</body>\n")
            .append("</html>");
        return html.toString();
    }
}