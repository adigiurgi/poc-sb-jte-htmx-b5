package com.example.webapp.infrastructure.adapters.in.cli;

import com.example.webapp.application.dto.command.UserAppCreateDto;
import com.example.webapp.application.dto.command.UserProfileCreateDto;
import com.example.webapp.application.dto.command.UserRoleCreateDto;
import com.example.webapp.application.ports.in.cli.UserAppCliApi;
import com.example.webapp.application.ports.in.cli.UserProfileCliApi;
import com.example.webapp.application.ports.in.cli.UserRoleCliApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@ConditionalOnProperty(name = "app.cli.enabled", havingValue = "true")
public class UserManagementCliRunner implements CommandLineRunner {

    private final UserAppCliApi userAppCliApi;
    private final UserProfileCliApi userProfileCliApi;
    private final UserRoleCliApi userRoleCliApi;

    @Override
    public void run(String... args) {
        if (args.length < 1) {
            printUsage();
            return;
        }

        try {
            switch (args[0].toLowerCase()) {
                case "create-user" -> handleCreateUser(args);
                case "create-profile" -> handleCreateProfile(args);
                case "create-role" -> handleCreateRole(args);
                case "help" -> printUsage();
                default -> {
                    log.error("Unknown command: {}", args[0]);
                    printUsage();
                }
            }
        } catch (Exception e) {
            log.error("Error executing command: {}", e.getMessage(), e);
            printUsage();
        }
    }

    private void handleCreateUser(String[] args) {
        if (args.length < 5) {
            log.error("Not enough arguments for create-user command");
            printCreateUserUsage();
            return;
        }

        String username = args[1];
        String email = args[2];
        String firstName = args[3];
        String lastName = args[4];

        UserAppCreateDto userAppCreateDto = new UserAppCreateDto(username, email, firstName, lastName);
        Long userId = userAppCliApi.createUser(userAppCreateDto);

        log.info("User created successfully with ID: {}", userId);
    }

    private void handleCreateProfile(String[] args) {
        if (args.length < 3) {
            log.error("Not enough arguments for create-profile command");
            printCreateProfileUsage();
            return;
        }

        Long userId = Long.parseLong(args[1]);
        String profileName = args[2];

        UserProfileCreateDto userProfileCreateDto = new UserProfileCreateDto(null, userId, profileName);
        Long profileId = userProfileCliApi.createUserProfile(userProfileCreateDto);

        log.info("Profile created successfully with ID: {}", profileId);
    }

    private void handleCreateRole(String[] args) {
        if (args.length < 4) {
            log.error("Not enough arguments for create-role command");
            printCreateRoleUsage();
            return;
        }

        Long userId = Long.parseLong(args[1]);
        String roleName = args[2];
        String roleDescription = args[3];

        UserRoleCreateDto userRoleCreateDto = new UserRoleCreateDto(null, userId, roleName, roleDescription);
        Long roleId = userRoleCliApi.createUserRole(userRoleCreateDto);

        log.info("Role created successfully with ID: {}", roleId);
    }

    private void printUsage() {
        log.info("Available commands:");
        log.info("  create-user <username> <email> <firstName> <lastName>");
        log.info("  create-profile <userId> <profileName>");
        log.info("  create-role <userId> <roleName> <roleDescription>");
        log.info("  help - Show this help message");
    }

    private void printCreateUserUsage() {
        log.info("Usage: create-user <username> <email> <firstName> <lastName>");
    }

    private void printCreateProfileUsage() {
        log.info("Usage: create-profile <userId> <profileName>");
    }

    private void printCreateRoleUsage() {
        log.info("Usage: create-role <userId> <roleName> <roleDescription>");
    }
}
