package com.skatingSchool.v1.infraestructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "instructors")
public class InstructorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Es una relacion uno a uno, evitando repitacion de datos
    // Un usuario no puede volver hacer un instructor despues de ser registrado por lo menos una vez

    //Lo manejan este onetoone y el unique en la columna
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

    @Column(nullable = true, length = 200)
    private String experience;

}
