package com.example.spring_mysql.dto;

import com.example.spring_mysql.entities.User;
import com.example.spring_mysql.enums.AppointmentStatus;

import java.time.LocalDateTime;

public record AppointmentRequestDTO(User patient, User doctor) {
}
