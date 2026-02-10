package com.example.spring_mysql.dto;

import com.example.spring_mysql.entities.User;
import com.example.spring_mysql.enums.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentResponseDTO(UUID id, User patient, User doctor, LocalDateTime dateUpdate, AppointmentStatus status, LocalDateTime dateCreated) {
}
