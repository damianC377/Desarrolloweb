package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.infraestructure.persistence.entities.StudentEntity;

public class StudentMapper {

    public static StudentEntity toEntity(Student student) {
        if (student == null) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(student.getStudentId());
        studentEntity.setUserId(student.getUserId());
        studentEntity.setActive(student.getActive());

        return studentEntity;
    }

    public static Student toDomain(StudentEntity studentEntity) {
        if (studentEntity == null) {
            return null;
        }

        Student student = new Student();
        student.setStudentId(studentEntity.getStudentId());
        student.setUserId(studentEntity.getUserId());
        student.setActive(studentEntity.getActive());

        return student;
    }
}
