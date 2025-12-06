package com.skatingSchool.v1.adapter.in.restcontrollers;

import java.util.Map;
import java.util.HashMap;

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


    @PostMapping("/register-student")
    public ResponseEntity<Map<String, Object>> createUsers(@RequestBody UserResquest request) throws Exception {
        User user = userRestMapper.toDomain(request);
        Long studentId = userUseCase.createUserStudent(user);

        UserResponse userResponse = userRestMapper.toResponse(user);

        Map<String, Object> response = new HashMap<>();
        response.put("user", userResponse);
        response.put("studentId", studentId);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
        
    }
}