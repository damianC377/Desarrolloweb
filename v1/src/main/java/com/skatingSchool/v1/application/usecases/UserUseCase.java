package com.skatingSchool.v1.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.model.enums.Rol;
import com.skatingSchool.v1.domain.service.CreateUserService;

/**
 * Caso de uso para gestión de usuarios.
 * Combina las operaciones de autenticación, registro y gestión de usuarios.
 */
@Service
public class UserUseCase {

    @Autowired
    private CreateUserService createUserService;

    /**
     * Registra un nuevo usuario en el sistema.
     * Por defecto asigna el rol STUDENT.
     * 
     * @param user Usuario a registrar
     * @throws Exception Si hay error en la creación
     */
    public void createUser(User user) throws Exception {
        user.setRol(Rol.STUDENT);
        createUserService.createUser(user);
    }
}