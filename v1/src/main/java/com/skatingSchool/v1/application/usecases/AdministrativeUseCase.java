package com.skatingSchool.v1.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.service.CreateInstructorService;
import com.skatingSchool.v1.domain.service.FindStudentService;


import java.util.List;

@Service
public class AdministrativeUseCase {

    @Autowired
    private CreateInstructorService createInstructorService;

     @Autowired
    private FindStudentService findStudentService;

    public void createInstructor(String experience, Long userId) throws Exception {
        Instructor instructor = new Instructor();
        instructor.setExperience(experience);

        createInstructorService.createInstructor(instructor, userId);
      
    }

    public List<Student> findAllStudents() throws Exception {
        return findStudentService.findAllStudents();
    }
    
}
