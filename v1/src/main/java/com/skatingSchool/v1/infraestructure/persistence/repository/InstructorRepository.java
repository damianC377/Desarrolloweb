package com.skatingSchool.v1.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skatingSchool.v1.infraestructure.persistence.entities.InstructorEntity;


@Repository
public interface InstructorRepository extends JpaRepository<InstructorEntity, Long> {
    
    public InstructorEntity findByUser(Long user);
}
