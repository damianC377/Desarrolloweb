package com.skatingSchool.v1.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.port.CreateInstructorPort;
import com.skatingSchool.v1.domain.port.FindInstructorPort;
import com.skatingSchool.v1.infraestructure.persistence.repository.InstructorRepository;
import com.skatingSchool.v1.infraestructure.persistence.entities.InstructorEntity;
import com.skatingSchool.v1.infraestructure.persistence.mapper.InstructorMapper;

@Service
public class InstructorAdapter implements CreateInstructorPort, FindInstructorPort {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public void save(Instructor instructor) {
        instructorRepository.save(InstructorMapper.toEntity(instructor));

    }

    @Override
    public Instructor findByUserId(Long userId) {
        InstructorEntity entity = instructorRepository.findByUser(userId);
        return InstructorMapper.toDomain(entity);

    }

    
}
