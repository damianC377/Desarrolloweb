package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.infraestructure.persistence.entities.InstructorEntity;

public class InstructorMapper {

    public static InstructorEntity toEntity(Instructor instructor){
        if (instructor == null) {
            return null;
            
        }

        InstructorEntity instructorEntity = new InstructorEntity();
        instructorEntity.setInstructorId(instructor.getInstructorId());
        instructorEntity.setUser(instructor.getUserId());
        instructorEntity.setExperience(instructor.getExperience());
        
        return instructorEntity;
    }


    public static Instructor toDomain(InstructorEntity instructorEntity){
        if (instructorEntity == null) {
            return null;
            
        }

        Instructor instructor = new Instructor();
        instructor.setInstructorId(instructorEntity.getInstructorId());
        instructor.setUserId(instructorEntity.getUser());
        instructor.setExperience(instructorEntity.getExperience());
        
        return instructor;
    }

}