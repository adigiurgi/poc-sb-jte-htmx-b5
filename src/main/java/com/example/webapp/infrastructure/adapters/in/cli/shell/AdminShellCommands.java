package com.example.webapp.infrastructure.adapters.in.cli.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.Availability;

import lombok.extern.slf4j.Slf4j;

@ShellComponent
@Slf4j
public class AdminShellCommands {

    @ShellMethod(key = "system-info", value = "Afișează informații despre sistem")
    public String systemInfo() {
        Runtime runtime = Runtime.getRuntime();
        long mb = 1024 * 1024;
        
        return "Informații despre sistem:\n" +
               "-------------------------\n" +
               "Memoria liberă (MB): " + runtime.freeMemory() / mb + "\n" +
               "Memoria maximă (MB): " + runtime.maxMemory() / mb + "\n" +
               "Memoria totală (MB): " + runtime.totalMemory() / mb + "\n" +
               "Procesoare disponibile: " + runtime.availableProcessors() + "\n" +
               "Versiune Java: " + System.getProperty("java.version") + "\n" +
               "Sistem de operare: " + System.getProperty("os.name");
    }

    @ShellMethod(key = "app-help", value = "Afișează ghid de utilizare pentru comanda CLI")
    public String help() {
        StringBuilder helpText = new StringBuilder();
        helpText.append("WEBAPP CLI - Ghid de utilizare\n");
        helpText.append("===========================\n\n");
        helpText.append("Comenzi disponibile:\n\n");
        
        helpText.append("1. Gestionare utilizatori:\n");
        helpText.append("   create-user <username> <firstname> <lastname> - Creează un utilizator nou\n\n");
        
        helpText.append("2. Gestionare profiluri:\n");
        helpText.append("   create-profile <userId> <profileName> - Creează un profil pentru un utilizator\n\n");
        
        helpText.append("3. Gestionare roluri:\n");
        helpText.append("   create-role <userId> <roleName> - Creează un rol pentru un utilizator\n\n");
        
        helpText.append("4. Utilități:\n");
        helpText.append("   system-info - Afișează informații despre sistem\n");
        helpText.append("   app-help - Afișează acest mesaj de ajutor\n");
        
        return helpText.toString();
    }
}
