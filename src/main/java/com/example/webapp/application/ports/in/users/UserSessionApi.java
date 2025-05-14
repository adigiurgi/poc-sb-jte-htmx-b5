package com.example.webapp.application.ports.in.users;

import com.example.webapp.application.dto.query.UserProfileDto;

import java.util.List;

public interface UserSessionApi {

    List<UserProfileDto> showUserProfiles(Long idUser, Long idProfile);
    void setNewActiveProfile(Long idProfile);

}
