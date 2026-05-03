package com.skatingSchool.v1.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.port.CreateInstructorPort;
import com.skatingSchool.v1.domain.port.FindInstructorPort;
import com.skatingSchool.v1.infraestructure.persistence.entities.InstructorEntity;
import com.skatingSchool.v1.infraestructure.persistence.mapper.InstructorMapper;
import com.skatingSchool.v1.infraestructure.persistence.repository.InstructorRepository;

@Service
public class InstructorAdapter implements CreateInstructorPort, FindInstructorPort {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public Instructor save(Instructor instructor) {
        InstructorEntity entity = instructorRepository.save(
                InstructorMapper.toEntity(instructor)
        );
        return InstructorMapper.toDomain(entity);
    }

    @Override
    public Instructor findByUserId(Long userId) {
        InstructorEntity entity = instructorRepository.findByUserId(userId);
        return entity != null ? InstructorMapper.toDomain(entity) : null;
    }

   @Override
public Instructor findById(Long instructorId) {
    InstructorEntity entity = instructorRepository.findById(instructorId).orElse(null);
    return entity != null ? InstructorMapper.toDomain(entity) : null;
}

}
