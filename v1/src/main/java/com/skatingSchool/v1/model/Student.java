package com.skatingSchool.v1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    // Es una relacion uno a uno, evitando repitacion de datos
    // Un usuario no puede volver hacer un estudiante despues de ser registrado por lo menos una vez
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = true, length = 50)
    private String paymentMethod;

}
