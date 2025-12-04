package com.skatingSchool.v1.application.usecases;

import com.skatingSchool.v1.domain.service.CreateUserService;
import com.skatingSchool.v1.domain.model.User;

public class UserUseCase {

    private CreateUserService createUserService;

    public void createUser(User user) throws Exception {
        createUserService.createUser(user);
    }

}
