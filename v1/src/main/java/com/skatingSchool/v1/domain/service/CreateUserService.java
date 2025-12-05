package com.skatingSchool.v1.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.port.CreateUserPort;
import com.skatingSchool.v1.domain.port.FindUserPort;

@Service()
public class CreateUserService {

    @Autowired
    CreateUserPort createUserPort;

    @Autowired
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
