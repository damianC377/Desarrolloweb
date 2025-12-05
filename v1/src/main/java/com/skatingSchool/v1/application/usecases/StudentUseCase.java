package com.skatingSchool.v1.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.service.CreateStudentService;

@Service
public class StudentUseCase {

    @Autowired
    private CreateStudentService createStudentService;

    public void createStudent(Student student) throws Exception {
        createStudentService.createStudent(student);
    }
}
