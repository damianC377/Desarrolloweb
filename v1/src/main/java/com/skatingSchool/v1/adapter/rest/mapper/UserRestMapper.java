package com.skatingSchool.v1.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.builder.Userbuilder;
import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.adapter.rest.request.UserResquest;
import com.skatingSchool.v1.adapter.rest.response.UserResponse;


@Component
public class UserRestMapper {

    @Autowired
    private Userbuilder userbuilder;

    public User toDomain(UserResquest req) throws Exception {
        if(req == null){
            return null;
        }

        User u = userbuilder.build(
            req.getDocument(),
            req.getName(),
            req.getLastname(),
            req.getEmail(),
            req.getPhone(),
            req.getAddress(),
            req.getUsername(),
            req.getPassword()

        );

        return u;
                
    }

    public UserResponse toResponse(User user) {
        if(user == null){
            return null;
        }

        UserResponse resp = new UserResponse();
        resp.setDocument(user.getDocument());
        resp.setName(user.getName());
        resp.setLastname(user.getLastname());
        resp.setEmail(user.getEmail());
        resp.setPhone(user.getPhone());
        resp.setAddress(user.getAddress());
        resp.setUsername(user.getUsername());
        resp.setRol(user.getRol() != null ? user.getRol().name() : null);

        return resp;
    }

}
