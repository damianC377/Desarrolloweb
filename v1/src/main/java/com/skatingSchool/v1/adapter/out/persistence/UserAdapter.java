package com.skatingSchool.v1.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.port.CreateUserPort;
import com.skatingSchool.v1.domain.port.FindUserPort;
import com.skatingSchool.v1.infraestructure.persistence.entities.UserEntity;
import com.skatingSchool.v1.infraestructure.persistence.mapper.UserMapper;
import com.skatingSchool.v1.infraestructure.persistence.repository.UserRepository;

@Service
public class UserAdapter implements CreateUserPort, FindUserPort{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(UserMapper.toEntity(user));
    }

     @Override
    public User findUserByDocument(Long document) {
        UserEntity entity = userRepository.findByDocument(document);
        return UserMapper.toDomain(entity);
    }

    @Override
    public User findUserByUsername(String username) {
        UserEntity entity = userRepository.findByUsername(username);
        return UserMapper.toDomain(entity);
    }

    @Override
    public User findUserByEmail(String email) {
        UserEntity entity = userRepository.findByEmail(email);
        return UserMapper.toDomain(entity);
    }
}
