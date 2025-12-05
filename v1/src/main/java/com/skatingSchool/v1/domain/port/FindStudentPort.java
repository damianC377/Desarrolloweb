package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Student;

public interface FindStudentPort {

    Student findById(Long studentId);

    Student findByUserId(Long userId);

    Student findActiveStudent(Long studentId);
}
