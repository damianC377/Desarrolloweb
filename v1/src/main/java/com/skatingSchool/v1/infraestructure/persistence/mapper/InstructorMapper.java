package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.infraestructure.persistence.entities.InstructorEntity;

public class InstructorMapper {

    public static InstructorEntity toEntity(Instructor instructor) {
        if (instructor == null) {
            return null;
        }

        InstructorEntity entity = new InstructorEntity();
        entity.setInstructorId(instructor.getInstructorId());
        entity.setUserId(instructor.getUserId());
        entity.setExperience(instructor.getExperience());

        return entity;
    }

    
    public static Instructor toDomain(InstructorEntity entity) {
        if (entity == null) {
            return null;
        }

        Instructor instructor = new Instructor();
        instructor.setInstructorId(entity.getInstructorId());
        instructor.setUserId(entity.getUserId());
        instructor.setExperience(entity.getExperience());

        return instructor;
    }
}
