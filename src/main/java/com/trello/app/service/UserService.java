package com.trello.app.service;


import com.trello.app.dto.UserRequestDTO;
import com.trello.app.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO register(UserRequestDTO request);
}