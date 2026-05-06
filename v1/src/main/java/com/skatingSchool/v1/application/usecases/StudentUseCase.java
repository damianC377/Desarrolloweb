package com.skatingSchool.v1.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.service.CreateStudentService;
import com.skatingSchool.v1.domain.service.FindStudentService;

import java.util.List;

@Service
public class StudentUseCase {

    @Autowired
    private CreateStudentService createStudentService;

    @Autowired
    private FindStudentService findStudentService;

   
    public void createStudent(Student student) throws Exception {
        createStudentService.createStudent(student);
    }

   
    public List<Student> findbyByClassId(Long classId) throws Exception {
    return findStudentService.findByClassId(classId);
}
}