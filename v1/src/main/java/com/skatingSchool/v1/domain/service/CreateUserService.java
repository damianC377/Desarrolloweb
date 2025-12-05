package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.port.CreateUserPort;
import com.skatingSchool.v1.domain.port.FindUserPort;

public class CreateUserService {

    CreateUserPort createUserPort;
    FindUserPort findUserPort;

    public void createUser(User user) throws Exception{

        if (findUserPort.findUserByDocument(user.getDocument()) != null) {
            throw new Exception("Usuario con documento " + user.getDocument() + " ya existe.");
        } 

        if (findUserPort.findUserByUsername(user.getUsername()) != null) {
            throw new Exception("Usuario con nombre de usuario " + user.getUsername() + " ya existe.");
        }

        if (findUserPort.findUserByEmail(user.getEmail()) != null) {
            throw new Exception("Usuario con email " + user.getEmail() + " ya existe.");
        }

        createUserPort.save(user);
    }
}
