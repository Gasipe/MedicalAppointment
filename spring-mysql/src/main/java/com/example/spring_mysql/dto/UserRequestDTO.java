package com.example.spring_mysql.dto;

import com.example.spring_mysql.enums.UserRole;

import javax.management.relation.Role;

public record UserRequestDTO(String name, String email, UserRole role) {
}
