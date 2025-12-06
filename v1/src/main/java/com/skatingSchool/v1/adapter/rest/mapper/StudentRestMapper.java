package com.skatingSchool.v1.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.builder.Studentbuilder;
import com.skatingSchool.v1.adapter.rest.request.StudentRequest;
import com.skatingSchool.v1.adapter.rest.response.StudentResponse;
import com.skatingSchool.v1.domain.model.Student;

@Component
public class StudentRestMapper {

    @Autowired
    private Studentbuilder studentbuilder;

    public Student toDomain(StudentRequest req) throws Exception {
        if (req == null) {
            return null;
        }

        Student student = studentbuilder.build(
            req.getUserId()
        );

        return student;
    }

    public StudentResponse toResponse(Student student) {
        if (student == null) {
            return null;
        }

        StudentResponse resp = new StudentResponse();
        resp.setUserId(student.getUserId());

        return resp;
    }
}
