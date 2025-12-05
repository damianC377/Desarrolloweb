package com.skatingSchool.v1.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skatingSchool.v1.infraestructure.persistence.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByDocument(Long document);

    public UserEntity findByUsername(String username);

    public UserEntity findByEmail(String email);

}
