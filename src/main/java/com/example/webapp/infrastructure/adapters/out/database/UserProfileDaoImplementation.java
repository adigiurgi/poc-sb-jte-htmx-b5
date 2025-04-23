package com.example.webapp.infrastructure.adapters.out.database;

import com.example.webapp.application.dto.command.UserProfileCreateDto;
import com.example.webapp.application.ports.out.database.UserProfileDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserProfile;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class UserProfileDaoImplementation implements UserProfileDao {

    private final UserProfileRepository userProfileAppRepository;
    
    @Override
    public Long saveUserProfile(UserProfileCreateDto userProfileCreateDto) {
        UserProfile userProfile = UserProfile.builder()
                .idUser(userProfileCreateDto.idUser())
                .profileName(userProfileCreateDto.profileName())
                .insertedAt(OffsetDateTime.now())
                .build();

        UserProfile savedUserProfile = userProfileAppRepository.save(userProfile);
        return savedUserProfile.getId();
    }
}
