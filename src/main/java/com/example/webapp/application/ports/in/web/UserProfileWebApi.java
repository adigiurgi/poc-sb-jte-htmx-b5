package com.example.webapp.application.ports.in.web;

import com.example.webapp.application.domain.models.UserProfile;

import java.util.List;

public interface UserProfileWebApi {

    List<UserProfile> showUserProfiles(Long idUser);
}
