package com.skatingSchool.v1.adapter.rest.mapper;

import com.skatingSchool.v1.adapter.in.builder.ClassBuilder;
import com.skatingSchool.v1.adapter.rest.request.ClassRequest;
import com.skatingSchool.v1.adapter.rest.response.ClassResponse;
import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassRestMapper {

    @Autowired
    private ClassBuilder classBuilder;

    /**
     * Convierte ClassRequest a objeto de dominio Class usando ClassBuilder
     */
    public Class toDomain(ClassRequest req) throws Exception {
        if (req == null) {
            return null;
        }

        // Convierte los IDs de estudiantes (String) a List<Student>
        List<Student> students = null;
        if (req.getStudentsIds() != null && !req.getStudentsIds().isBlank()) {
            students = new ArrayList<>();
            for (Long id : new com.skatingSchool.v1.adapter.in.validator.ClassValidator().studentsIdsValidator(req.getStudentsIds())) {
                Student s = new Student();
                s.setStudentId(id);
                students.add(s);
            }
        }

        return classBuilder.build(
                req.getClassName(),
                req.getLevel(),
                req.getSchedule(),
                req.getInstructorId(),
                students
        );
    }

    /**
     * Convierte objeto de dominio Class a ClassResponse
     */
    public ClassResponse toResponse(Class domain) {
        if (domain == null) {
            return null;
        }

        ClassResponse resp = new ClassResponse();
        resp.setClassId(domain.getClassId());
        resp.setClassName(domain.getClassName());
        resp.setLevel(domain.getLevel());
        resp.setSchedule(domain.getSchedule());
        resp.setInstructorId(domain.getInstructorId());

        if (domain.getStudents() != null) {
            List<Long> studentIds = new ArrayList<>();
            for (Student s : domain.getStudents()) {
                studentIds.add(s.getStudentId());
            }
            resp.setStudentsIds(studentIds);
        }

        return resp;
    }
}
