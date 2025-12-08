package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Student;
import java.util.List;

public interface FindStudentPort {

    Student findById(Long studentId);

    Student findByUserId(Long userId);

    Student findActiveStudent(Long studentId);

    List<Student> findAll();

    
}
