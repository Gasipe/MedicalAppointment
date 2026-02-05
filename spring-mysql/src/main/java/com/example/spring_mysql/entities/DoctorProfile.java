package com.example.spring_mysql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class DoctorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO.UUID)
    private UUID id;

    @OneToOne
    @MapsId
    private User user;

    @Column(nullable = false)
    private String crm;
}
