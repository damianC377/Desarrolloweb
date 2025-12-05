package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.infraestructure.persistence.entities.ClassEntity;
import com.skatingSchool.v1.infraestructure.persistence.entities.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClassMapper {

    public static ClassEntity toEntity(Class domain) {
        if (domain == null) {
            return null;
        }

        ClassEntity classentity = new ClassEntity();
        classentity.setClassId(domain.getClassId());
        classentity.setClassName(domain.getClassName());
        classentity.setLevel(domain.getLevel());
        classentity.setSchedule(domain.getSchedule());

        if (domain.getInstructorId() != null) {
            var instructorEntity = new com.skatingSchool.v1.infraestructure.persistence.entities.InstructorEntity();
            instructorEntity.setId(domain.getInstructorId());
            classentity.setInstructor(instructorEntity);
        }

        if (domain.getStudents() != null) {
            List<StudentEntity> studentEntities = domain.getStudents().stream()
                    .map(StudentMapper::toEntity)
                    .collect(Collectors.toList());
            classentity.setStudents(studentEntities);
        }

        return classentity;
    }

    public static Class toDomain(ClassEntity classentity) {
        if (classentity == null) {
            return null;
        }

        Class domain = new Class();
        domain.setClassId(classentity.getClassId());
        domain.setClassName(classentity.getClassName());
        domain.setLevel(classentity.getLevel());
        domain.setSchedule(classentity.getSchedule());

        if (classentity.getInstructor() != null) {
            domain.setInstructorId(classentity.getInstructor().getId());
        }

        if (classentity.getStudents() != null) {
            List<Student> students = classentity.getStudents().stream()
                    .map(StudentMapper::toDomain)
                    .collect(Collectors.toList());
            domain.setStudents(students);
        }

        return domain;
    }
}
