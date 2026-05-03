package com.skatingSchool.v1.infraestructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instructors")
public class InstructorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(nullable = true, length = 200)
    private String experience;
}
