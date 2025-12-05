package com.skatingSchool.v1.infraestructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(nullable = false, unique = true)
    private Long document;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String lastname;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 100)
    private String phone;

    @Column(nullable = true, length = 150)
    private String address;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "rol", nullable = false, length = 50)
    private String rol;
    
}
