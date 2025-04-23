package com.example.webapp.infrastructure.adapters.in.cli.shell;

import com.example.webapp.application.dto.command.UserAppCreateDto;
import com.example.webapp.application.ports.in.cli.UserAppCliApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
@Slf4j
public class UserShellCommands {

    private final UserAppCliApi userAppCliApi;
    
    @ShellMethod(key = "create-user", value = "Creează un nou utilizator (create-user <username> <firstname> <lastname>)")
    public String createUser(
            @ShellOption(help = "Numele de utilizator") String username,
            @ShellOption(help = "Prenumele utilizatorului") String firstName,
            @ShellOption(help = "Numele de familie al utilizatorului") String lastName) {
        
        try {
            log.info("Creez utilizator nou cu username: {}", username);
            UserAppCreateDto userAppCreateDto = new UserAppCreateDto(username, firstName, lastName);
            Long userId = userAppCliApi.createUser(userAppCreateDto);
            return "Utilizator creat cu succes cu ID: " + userId;
        } catch (Exception e) {
            log.error("Eroare la crearea utilizatorului: {}", e.getMessage(), e);
            return "Eroare la crearea utilizatorului: " + e.getMessage();
        }
    }
}
