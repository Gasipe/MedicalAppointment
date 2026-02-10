package com.example.spring_mysql.entities;

import com.example.spring_mysql.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "patiend_id", nullable = false)
    private User patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id",  nullable = false)
    private User doctor;

    @Column(nullable = false)
    private LocalDateTime dateUpdate;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Column(nullable = false)
    private LocalDateTime dateCreated;
}
