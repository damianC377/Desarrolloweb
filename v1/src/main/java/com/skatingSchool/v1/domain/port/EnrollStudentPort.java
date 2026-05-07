package com.skatingSchool.v1.domain.port;
import com.skatingSchool.v1.domain.model.Student;

public interface EnrollStudentPort {
    void enrollStudent(Long classId, Student student);
    boolean isStudentEnrolled(Long classId, Long studentId);
}