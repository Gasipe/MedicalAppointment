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
    @GeneratedValue(strategy = GenerationType.AUTO.UUID)
    private UUID id;

    @ManyToOne
    private User patient;

    @ManyToOne
    private User doctor;

    @Column(nullable = false)
    private LocalDateTime dateUpdate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status;

    @Column(nullable = false)
    private LocalDateTime dateCreated;
}
