package com.skatingSchool.v1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    // Es una relacion uno a uno, evitando repitacion de datos
    // Un usuario no puede volver hacer un instructor despues de ser registrado por lo menos una vez

    //Lo manejan este onetoone y el unique en la columna
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = true, length = 200)
    private String experience;

}
