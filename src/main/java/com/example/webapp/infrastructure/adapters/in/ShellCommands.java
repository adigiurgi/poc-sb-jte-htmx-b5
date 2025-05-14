package com.example.webapp.infrastructure.adapters.in;

import com.example.webapp.application.dto.command.UserAppCreateDto;
import com.example.webapp.application.dto.command.UserProfileCreateDto;
import com.example.webapp.application.dto.command.UserRoleCreateDto;
import com.example.webapp.application.ports.in.users.UserAdministrationApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@Slf4j
@RequiredArgsConstructor
public class ShellCommands {

    private final UserAdministrationApi userAdministrationApi;

    @ShellMethod(key = "create-user", value = "Creează un nou utilizator (create-user <username> <firstname> <lastname>)")
    public String createUser(
            @ShellOption(help = "Numele de utilizator") String username,
            @ShellOption(help = "Prenumele utilizatorului") String firstName,
            @ShellOption(help = "Numele de familie al utilizatorului") String lastName) {

        try {
            log.info("Creez utilizator nou cu username: {}", username);
            UserAppCreateDto userAppCreateDto = new UserAppCreateDto(username, firstName, lastName);
            Long userId = userAdministrationApi.createUser(userAppCreateDto);
            return "Utilizator creat cu succes cu ID: " + userId;
        } catch (Exception e) {
            log.error("Eroare la crearea utilizatorului: {}", e.getMessage(), e);
            return "Eroare la crearea utilizatorului: " + e.getMessage();
        }
    }

    @ShellMethod(key = "create-role", value = "Creează un nou rol pentru un utilizator (create-role <userId> <roleName>)")
    public String createRole(
            @ShellOption(help = "ID-ul utilizatorului") Long userId,
            @ShellOption(help = "Numele rolului") String roleName) {

        try {
            log.info("Creez rol nou pentru utilizatorul cu ID: {}", userId);
            UserRoleCreateDto userRoleCreateDto = new UserRoleCreateDto(null, userId, roleName);
            Long roleId = userAdministrationApi.createUserRole(userRoleCreateDto);
            return "Rol creat cu succes cu ID: " + roleId;
        } catch (Exception e) {
            log.error("Eroare la crearea rolului: {}", e.getMessage(), e);
            return "Eroare la crearea rolului: " + e.getMessage();
        }
    }

    @ShellMethod(key = "create-profile", value = "Creează un nou profil pentru un utilizator (create-profile <userId> <profileName>)")
    public String createProfile(
            @ShellOption(help = "ID-ul utilizatorului") Long userId,
            @ShellOption(help = "Numele profilului") String profileName) {

        try {
            log.info("Creez profil nou pentru utilizatorul cu ID: {}", userId);
            UserProfileCreateDto userProfileCreateDto = new UserProfileCreateDto(null, userId, profileName);
            Long profileId = userAdministrationApi.createUserProfile(userProfileCreateDto);
            return "Profil creat cu succes cu ID: " + profileId;
        } catch (Exception e) {
            log.error("Eroare la crearea profilului: {}", e.getMessage(), e);
            return "Eroare la crearea profilului: " + e.getMessage();
        }
    }
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
