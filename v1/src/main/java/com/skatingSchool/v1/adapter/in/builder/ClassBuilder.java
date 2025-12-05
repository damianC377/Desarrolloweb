package com.skatingSchool.v1.adapter.in.builder;

import com.skatingSchool.v1.adapter.in.validator.ClassValidator;
import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ClassBuilder {

    @Autowired
    private ClassValidator validator;

    public ClassBuilder() {
        this.validator = new ClassValidator();
    }
    
    public Class build(String className, String level, String schedule, String instructorId, List<Student> students) throws Exception {
        Class skatingClass = new Class();

        skatingClass.setClassName(validator.classNameValidator(className));
        skatingClass.setLevel(validator.levelValidator(level));
        skatingClass.setSchedule(validator.scheduleValidator(schedule));
        skatingClass.setInstructorId(validator.instructorIdValidator(instructorId));

        if (students != null) {
            skatingClass.setStudents(students);
        }

        return skatingClass;
    }
}
