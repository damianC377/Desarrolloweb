package com.skatingSchool.v1.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.validator.InstructorValidator;
import com.skatingSchool.v1.domain.model.Instructor;

@Component
public class Instructorbuilder {

    @Autowired
    private InstructorValidator validator;

    public Instructorbuilder() {
        this.validator = new InstructorValidator();
    }

    public Instructor build(String userId, String experience) throws Exception{

        Instructor instructor = new Instructor();
        instructor.setUserId(validator.userIdValidator(userId));
        instructor.setExperience(validator.experienceValidator(experience));
        
        return instructor;
    }
}
