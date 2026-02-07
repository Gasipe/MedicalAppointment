package com.example.spring_mysql.service;

import com.example.spring_mysql.Mapper.UserMapper;
import com.example.spring_mysql.dto.UserRequestDTO;
import com.example.spring_mysql.dto.UserResponseDTO;
import com.example.spring_mysql.entities.User;
import com.example.spring_mysql.repository.UserRepository;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (dto.role() == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }

        User user = new User();
        User saved = userRepository.save(user);
        return UserMapper.toDTO(saved);
    }

    @Override
    public UserResponseDTO findById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserMapper.toDTO(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper:: toDTO)
                .toList();
    }

    @Override
    public UserResponseDTO update(UUID id, UserRequestDTO dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setRole(dto.role());
        return UserMapper.toDTO(userRepository.save(user));
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
