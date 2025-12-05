package com.skatingSchool.v1.application.usecases;

import com.skatingSchool.v1.domain.service.CreateUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.model.enums.Rol;

@Service
public class UserUseCase {

    @Autowired
    private CreateUserService createUserService;

    public void createUser(User user) throws Exception {
        user.setRol(Rol.STUDENT);
        createUserService.createUser(user);
    }

}
