package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Student;

public interface CreateStudentPort {

    void save(Student student);
}
