package com.skatingSchool.v1.infraestructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = true, length = 255)
    private String description;

    @Column(nullable = true, length = 500)
    private String details;

    @Column(nullable = true, length = 150)
    private String location;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}
