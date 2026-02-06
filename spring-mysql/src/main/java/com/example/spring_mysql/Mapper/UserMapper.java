package com.example.spring_mysql.Mapper;

import com.example.spring_mysql.dto.UserRequestDTO;
import com.example.spring_mysql.dto.UserResponseDTO;
import com.example.spring_mysql.entities.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setRole(dto.role());
        return user;
    }

    public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
