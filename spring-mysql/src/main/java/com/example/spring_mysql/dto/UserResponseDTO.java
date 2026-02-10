package com.example.spring_mysql.dto;

import com.example.spring_mysql.entities.User;
import com.example.spring_mysql.enums.UserRole;

import javax.management.relation.Role;
import java.util.UUID;

public record UserResponseDTO(java.util.UUID id, String name, String email, UserRole role) {
}
