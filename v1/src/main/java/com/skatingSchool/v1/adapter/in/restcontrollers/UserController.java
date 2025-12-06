package com.skatingSchool.v1.adapter.in.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skatingSchool.v1.adapter.rest.mapper.UserRestMapper;
import com.skatingSchool.v1.adapter.rest.request.UserResquest;
import com.skatingSchool.v1.adapter.rest.response.UserResponse;
import com.skatingSchool.v1.application.usecases.UserUseCase;
import com.skatingSchool.v1.domain.model.User;

/**
 * Controlador REST para gestión de usuarios y autenticación.
 * Maneja las operaciones de login y registro.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserUseCase userUseCase;

    @Autowired
    private UserRestMapper userRestMapper;

    /**
     * Endpoint para registro de nuevos usuarios.
     * POST /api/v1/users/register
     * 
     * @param request Datos del usuario a registrar
     * @return ResponseEntity con los datos del usuario creado
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserResquest request) throws Exception {
        User user = userRestMapper.toDomain(request);
        userUseCase.createUser(user);

        return new ResponseEntity<>(
                userRestMapper.toResponse(user),
                HttpStatus.CREATED
        );
    }
}