package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Student;

public interface CreateStudentPort {

    Student save(Student student);
}
