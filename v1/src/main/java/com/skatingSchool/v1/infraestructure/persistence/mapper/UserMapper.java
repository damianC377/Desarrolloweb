package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.model.enums.Rol;
import com.skatingSchool.v1.infraestructure.persistence.entities.UserEntity;


public class UserMapper {


    public static UserEntity toEntity(User user){
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUserid(user.getUserid());
        userEntity.setDocument(user.getDocument());
        userEntity.setName(user.getName());
        userEntity.setLastname(user.getLastname());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        userEntity.setAddress(user.getAddress());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        if (user.getRol() != null) {
            userEntity.setRol(user.getRol().name());
        }

        return userEntity;
    }

    public static User toDomain(UserEntity userEntity){
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();
        user.setUserid(userEntity.getUserid());
        user.setDocument(userEntity.getDocument());
        user.setName(userEntity.getName());
        user.setLastname(userEntity.getLastname());
        user.setEmail(userEntity.getEmail());
        user.setPhone(userEntity.getPhone());
        user.setAddress(userEntity.getAddress());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());

        if (userEntity.getRol() != null) {
            user.setRol(Rol.valueOf(userEntity.getRol()));
        }
        return user;
    }
}
