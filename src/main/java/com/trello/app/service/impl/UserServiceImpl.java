package com.trello.app.service.impl;

import com.trello.app.dto.UserRequestDTO;
import com.trello.app.dto.UserResponseDTO;
import com.trello.app.entity.User;
import com.trello.app.exception.ResourceAlreadyExistsException;
import com.trello.app.repository.UserRepository;
import com.trello.app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO register(UserRequestDTO request) {

        // 1. Check if user exists
        userRepository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    throw new ResourceAlreadyExistsException("Email already exists");
                });

        // 2. Create entity
        User user = new User(
                request.getEmail(),
                request.getPassword() // will hash later
        );

        // 3. Save
        User saved = userRepository.save(user);

        // 4. Convert to response DTO
        return new UserResponseDTO(saved.getId(), saved.getEmail());
    }
}
