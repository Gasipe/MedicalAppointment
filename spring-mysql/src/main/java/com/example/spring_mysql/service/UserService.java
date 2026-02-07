package com.example.spring_mysql.service;

import com.example.spring_mysql.dto.UserRequestDTO;
import com.example.spring_mysql.dto.UserResponseDTO;
import com.example.spring_mysql.entities.User;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service

public interface UserService {

    UserResponseDTO create(UserRequestDTO dto);

    UserResponseDTO findById(UUID id);

    List<UserResponseDTO> findAll();

    UserResponseDTO update(UUID id, UserRequestDTO dto);

    void delete(UUID id);

}
