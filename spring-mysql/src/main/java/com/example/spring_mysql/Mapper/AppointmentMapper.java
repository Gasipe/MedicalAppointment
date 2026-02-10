package com.example.spring_mysql.Mapper;

import com.example.spring_mysql.dto.AppointmentResponseDTO;
import com.example.spring_mysql.entities.Appointment;

public class AppointmentMapper {

    public static AppointmentResponseDTO toDTO(Appointment appointment) {
        return new AppointmentResponseDTO(
                appointment.getId(),
                appointment.getPatient(),
                appointment.getDoctor(),
                appointment.getDateUpdate(),
                appointment.getStatus(),
                appointment.getDateCreated()
        );
    }
}
