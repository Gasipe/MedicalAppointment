package com.example.spring_mysql.service;

import com.example.spring_mysql.entities.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class AppointmentService {

    public AppointmentService schedule(UUID patientId, UUID doctorId, UUID secretaryId) {
        User patient =  userService.findById(patientId);
    }
}
