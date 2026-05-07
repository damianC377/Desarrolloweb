package com.skatingSchool.v1.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.service.CreateClassService;
import com.skatingSchool.v1.domain.service.FindClassService;
import com.skatingSchool.v1.domain.service.EnrollStudentService;

import java.util.List;

@Component
public class ClassUseCase {

    @Autowired
    private FindClassService findClassService;
    @Autowired
    private CreateClassService createClassService;
    @Autowired
    private EnrollStudentService enrollStudentService;

  

    public void createClass(Class skatingClass) throws Exception {
        createClassService.createClass(skatingClass);
    }

    public List<Class> getAllClasses() throws Exception {
        return findClassService.findAllClasses();
    }

    public Class getClassById(Long classId) throws Exception {
        return findClassService.findById(classId);
    }

    public List<Class> getClassesByInstructor(Long instructorId) throws Exception {
        return findClassService.findByInstructorId(instructorId);
    }

    public List<Class> getClassesBySchedule(java.time.LocalDateTime schedule) throws Exception {
        return findClassService.findBySchedule(schedule);
    }

 

    public List<Class> getAvailableClasses() throws Exception {
        return enrollStudentService.getAvailableClasses();
    }

    public void enrollStudent(Long classId, Student student) throws Exception {
        enrollStudentService.enrollStudent(classId, student);
    }


    public List<Class> getClassesByStudent(Long studentId) throws Exception {
    return findClassService.findByStudentId(studentId);
}
}