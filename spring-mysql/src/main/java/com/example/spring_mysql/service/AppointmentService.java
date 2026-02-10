package com.example.spring_mysql.service;

import com.example.spring_mysql.Mapper.AppointmentMapper;
import com.example.spring_mysql.dto.AppointmentRequestDTO;
import com.example.spring_mysql.dto.AppointmentResponseDTO;
import com.example.spring_mysql.entities.Appointment;
import com.example.spring_mysql.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service

public class AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }


    public AppointmentResponseDTO saveConsultation(AppointmentRequestDTO requestDTO) {
        Appointment appointment = new Appointment();
        Appointment save = repository.save(appointment);
        return AppointmentMapper.toDTO(save);
    }

    public AppointmentResponseDTO findConsultation(UUID id) {
        Appointment appointment = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        return AppointmentMapper.toDTO(appointment);
    }

    public List<AppointmentResponseDTO> findAllConsultation() {
        return repository.findAll()
                .stream()
                .map(AppointmentMapper:: toDTO)
                .toList();
    }
}
