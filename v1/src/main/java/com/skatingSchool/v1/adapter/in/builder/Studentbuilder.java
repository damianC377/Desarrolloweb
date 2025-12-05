package com.skatingSchool.v1.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.validator.StudentValidator;
import com.skatingSchool.v1.domain.model.Student;

@Component
public class Studentbuilder {

    @Autowired
    private StudentValidator validator;

    public Studentbuilder() {
        this.validator = new StudentValidator();
    }

    public Student build(String userId, String active) throws Exception {

        Student student = new Student();

        student.setUserId(validator.userIdValidator(userId));
        student.setActive(validator.activeValidator(active));

        return student;
    }
}
