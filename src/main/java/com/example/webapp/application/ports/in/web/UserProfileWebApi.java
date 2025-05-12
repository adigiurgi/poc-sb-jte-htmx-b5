package com.example.webapp.application.ports.in.web;

import com.example.webapp.application.domain.models.UserProfile;
import com.example.webapp.application.dto.query.UserProfileDto;

import java.util.List;

public interface UserProfileWebApi {

    List<UserProfileDto> showUserProfiles(Long idUser, Long idProfile);
}
