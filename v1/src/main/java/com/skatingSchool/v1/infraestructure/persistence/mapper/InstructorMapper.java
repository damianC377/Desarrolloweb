package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.infraestructure.persistence.entities.InstructorEntity;
import com.skatingSchool.v1.infraestructure.persistence.entities.UserEntity;

public class InstructorMapper {

    public static InstructorEntity toEntity(Instructor instructor){
        if (instructor == null) {
            return null;
            
        }

        
        
        InstructorEntity instructorEntity = new InstructorEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserid(instructor.getUserId());
        instructorEntity.setUser(userEntity);
        instructorEntity.setId(instructor.getInstructorId());
        instructorEntity.setExperience(instructor.getExperience());
        
        return instructorEntity;
    }


    public static Instructor toDomain(InstructorEntity instructorEntity){
        if (instructorEntity == null) {
            return null;
            
        }

        Instructor instructor = new Instructor();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserid(instructor.getUserId());
        instructorEntity.setUser(userEntity);
        instructor.setInstructorId(instructorEntity.getId());
        instructor.setExperience(instructorEntity.getExperience());
        
        return instructor;
    }

}