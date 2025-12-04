package com.skatingSchool.v1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Column(nullable = false)
    private Double amount;

    // hay uno principal, y este es secundario
    @Column(nullable = false, length = 50)
    private String paymentMethod;

}
