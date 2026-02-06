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
        return null;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User findEntityById(Long id) {
        return null;
    }
}
