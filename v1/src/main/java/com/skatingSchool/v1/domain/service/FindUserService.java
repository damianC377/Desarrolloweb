package com.skatingSchool.v1.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.port.FindUserPort;

@Service
public class FindUserService {

    @Autowired
    private FindUserPort findUserPort;
 
    public User findById(Long userId) throws Exception {
        User user = findUserPort.findById(userId);
        
        if (user == null) {
            throw new Exception("Usuario con ID " + userId + " no encontrado.");
        }
        
        return user;
    }
}
