package com.example.spring_mysql.dto;

import javax.management.relation.Role;

public record UserRequestDTO(String name, String email, Role role) {
}
