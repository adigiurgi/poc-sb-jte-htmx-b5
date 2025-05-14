package com.example.webapp.infrastructure.adapters.in;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.NestedServletException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * Controller global pentru gestionarea erorilor, funcționează atât în dev cât și în prod
 */
@Slf4j
@Controller
public class GlobalErrorController implements ErrorController {

    @Value("${spring.profiles.active:dev}")
    private String activeProfile;

    private static final String ERROR_PATH = "/error";

    /**
     * Gestionează toate tipurile de erori și le redirecționează către șabloanele JTE corespunzătoare
     */
    @RequestMapping(ERROR_PATH)
    public String handleError(HttpServletRequest request, HttpServletResponse response, Model model) {
        // Obținem detaliile despre eroare din atributele cererii
        Object statusObj = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object pathObj = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        Object messageObj = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object exceptionObj = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        
        Integer statusCode = 500; // Cod implicit pentru erori
        String path = request.getRequestURI();
        String error = "Eroare internă de server";
        String message = "A apărut o eroare internă la procesarea cererii.";
        String timestamp = new Date().toString();
        String trace = "";
        
        // Procesăm codul de stare
        if (statusObj != null) {
            statusCode = Integer.parseInt(statusObj.toString());
        }
        
        // Procesăm calea URL
        if (pathObj != null) {
            path = pathObj.toString();
        }
        
        // Procesăm tipul erorii
        if (exceptionObj != null) {
            error = exceptionObj.getClass().getName();
        }
        
        // Procesăm mesajul de eroare
        if (messageObj != null && !messageObj.toString().isEmpty()) {
            message = messageObj.toString();
        }
        
        // Procesăm stack trace-ul doar pentru profilul de dev
        if ("dev".equalsIgnoreCase(activeProfile) && exceptionObj != null) {
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
                trace = sw.toString();
            }
        }
        
        // Adăugăm datele în model pentru template
        model.addAttribute("contextPath", request.getContextPath());
        model.addAttribute("path", path);
        model.addAttribute("error", error);
        model.addAttribute("message", message);
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("trace", trace);
        
        // Pentru depanare
        log.error("Eroare gestionată: cod={}, cale={}, mesaj={}, trace={}", statusCode, path, message, trace);
        
        // Selectăm template-ul în funcție de codul de eroare
        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            return "error/404";
        } else {
            return "error/500";
        }
    }
}