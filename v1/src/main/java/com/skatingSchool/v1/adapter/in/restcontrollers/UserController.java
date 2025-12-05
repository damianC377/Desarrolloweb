package com.skatingSchool.v1.adapter.in.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skatingSchool.v1.adapter.rest.mapper.UserRestMapper;
import com.skatingSchool.v1.adapter.rest.request.UserResquest;
import com.skatingSchool.v1.adapter.rest.response.UserResponse;
import com.skatingSchool.v1.application.usecases.UserUseCase;
import com.skatingSchool.v1.domain.model.User;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserUseCase userUseCase;

    @Autowired
    private UserRestMapper userRestMapper;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUsers(@RequestBody UserResquest request) throws Exception {
        User user = userRestMapper.toDomain(request);
        userUseCase.createUser(user);

        return new ResponseEntity<>(
                userRestMapper.toResponse(user),
                HttpStatus.CREATED
        );
        
    }
}
