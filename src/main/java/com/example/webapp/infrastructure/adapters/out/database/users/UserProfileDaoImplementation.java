package com.example.webapp.infrastructure.adapters.out.database.users;

import com.example.webapp.application.domain.models.users.UserProfile;
import com.example.webapp.application.ports.out.database.users.UserProfileDao;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.users.UserProfileEntity;
import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories.users.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserProfileDaoImplementation implements UserProfileDao {

    private final UserProfileRepository userProfileAppRepository;
    
    @Override
    public Long saveUserProfile(UserProfile userProfile) {
        UserProfileEntity userProfileEntity = UserProfileEntity.builder()
                .idUser(userProfile.getIdUser())
                .profileName(userProfile.getProfileName())
                .insertedAt(OffsetDateTime.now())
                .build();

        UserProfileEntity savedUserProfileEntity = userProfileAppRepository.save(userProfileEntity);
        return savedUserProfileEntity.getId();
    }

    @Override
    public List<UserProfile> findUserProfiles(Long idUser) {
        List<UserProfileEntity> userProfileEntityList = userProfileAppRepository.findByIdUser(idUser);
        return userProfileEntityList.stream()
                .map(entity -> UserProfile.create(entity.getId(),
                        entity.getIdUser(),
                        entity.getProfileName()))
                .toList();
    }
}
