package com.example.spring_mysql.controller;

import com.example.spring_mysql.dto.AppointmentRequestDTO;
import com.example.spring_mysql.dto.AppointmentResponseDTO;
import com.example.spring_mysql.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/appointment")
@RestController

public class AppointmentController {
    public final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> findById(@RequestParam UUID id) {
        AppointmentResponseDTO response = service.findConsultation(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> findAll() {
        List<AppointmentResponseDTO> response = service.findAllConsultation();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AppointmentResponseDTO> create(@RequestBody AppointmentRequestDTO request) {
        AppointmentResponseDTO response = service.saveConsultation(request);
        return ResponseEntity.ok(response);
    }
}
