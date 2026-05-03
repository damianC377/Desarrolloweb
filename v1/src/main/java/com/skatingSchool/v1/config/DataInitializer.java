package com.skatingSchool.v1.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.application.usecases.UserUseCase;
import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.model.enums.Rol;

@Component
public class DataInitializer {

    @Autowired
    private UserUseCase userUseCase;

    @PostConstruct
    public void createAdmin() {

        try {
            User admin = new User();

            admin.setName("Admin");
            admin.setLastname("System");
            admin.setDocument(123456789L);
            admin.setEmail("admin@rollerspeed.com");
            admin.setPhone("3000000000");
            admin.setAddress("System");

            admin.setUsername("admin");
            admin.setPassword("1234");
            admin.setRol(Rol.ADMIN);

            userUseCase.createUserAdmin(admin);

            System.out.println("Admin creado correctamente");

        } catch (Exception e) {
            System.out.println("Admin ya existe, se omite creación");
        }
    }
}
