package com.skatingSchool.v1.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.validator.UserValidator;
import com.skatingSchool.v1.domain.model.User;


@Component 
public class Userbuilder {

    @Autowired
    private UserValidator validator;

    public Userbuilder() {
        this.validator = new UserValidator();
    }

    public User build(String document, String name, String lastname, String email, String phone, String address, String username, String password) throws Exception {
        User user = new User();
        user.setDocument(validator.documentValidator(document));
        user.setName(validator.nameValidator(name));
        user.setLastname(validator.lastnameValidator(lastname));
        user.setEmail(validator.emailValidator(email));
        user.setPhone(validator.phoneValidator(phone));
        user.setAddress(validator.addressValidator(address));
        user.setUsername(validator.usernameValidator(username));
        user.setPassword(validator.passwordValidator(password));
        
        return user;
    }
}
