package com.example.webapp.infrastructure.adapters.in.cli.shell;

import com.example.webapp.application.dto.command.UserProfileCreateDto;
import com.example.webapp.application.ports.in.cli.UserProfileCliApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
@Slf4j
public class ProfileShellCommands {

    private final UserProfileCliApi userProfileCliApi;
    
    @ShellMethod(key = "create-profile", value = "Creează un nou profil pentru un utilizator (create-profile <userId> <profileName>)")
    public String createProfile(
            @ShellOption(help = "ID-ul utilizatorului") Long userId,
            @ShellOption(help = "Numele profilului") String profileName) {
        
        try {
            log.info("Creez profil nou pentru utilizatorul cu ID: {}", userId);
            UserProfileCreateDto userProfileCreateDto = new UserProfileCreateDto(null, userId, profileName);
            Long profileId = userProfileCliApi.createUserProfile(userProfileCreateDto);
            return "Profil creat cu succes cu ID: " + profileId;
        } catch (Exception e) {
            log.error("Eroare la crearea profilului: {}", e.getMessage(), e);
            return "Eroare la crearea profilului: " + e.getMessage();
        }
    }
}
