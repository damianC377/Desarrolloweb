package com.skatingSchool.v1.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.service.CreateInstructorService;

@Service
public class Administrative {

    @Autowired
    private CreateInstructorService createInstructorService;

    public void createInstructor(String experience, Long userId) throws Exception {
        Instructor instructor = new Instructor();
        instructor.setExperience(experience);

        createInstructorService.createInstructor(instructor, userId);
      
    }
}
