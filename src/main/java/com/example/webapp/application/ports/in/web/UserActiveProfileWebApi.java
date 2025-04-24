package com.example.webapp.application.ports.in.web;

import com.example.webapp.application.domain.models.UserProfile;

import java.util.List;

public interface UserActiveProfileWebApi {

    void setNewActiveProfile(Long idProfile);
}
