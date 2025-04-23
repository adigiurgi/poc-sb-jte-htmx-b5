package com.example.webapp.infrastructure.adapters.in.cli.shell;

import com.example.webapp.application.dto.command.UserRoleCreateDto;
import com.example.webapp.application.ports.in.cli.UserRoleCliApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
@Slf4j
public class RoleShellCommands {

    private final UserRoleCliApi userRoleCliApi;
    
    @ShellMethod(key = "create-role", value = "Creează un nou rol pentru un utilizator (create-role <userId> <roleName>)")
    public String createRole(
            @ShellOption(help = "ID-ul utilizatorului") Long userId,
            @ShellOption(help = "Numele rolului") String roleName) {
        
        try {
            log.info("Creez rol nou pentru utilizatorul cu ID: {}", userId);
            UserRoleCreateDto userRoleCreateDto = new UserRoleCreateDto(null, userId, roleName);
            Long roleId = userRoleCliApi.createUserRole(userRoleCreateDto);
            return "Rol creat cu succes cu ID: " + roleId;
        } catch (Exception e) {
            log.error("Eroare la crearea rolului: {}", e.getMessage(), e);
            return "Eroare la crearea rolului: " + e.getMessage();
        }
    }
}
