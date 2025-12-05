package com.skatingSchool.v1.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.validator.ClassValidator;
import com.skatingSchool.v1.domain.model.Attendance;

import java.time.LocalDate;

@Component
public class AttendanceBuilder {

    @Autowired
    private ClassValidator validator;

    public AttendanceBuilder() {
        this.validator = new ClassValidator();
    }

    public Attendance build(String classSessionId, String studentId, String attendanceDate, String present) throws Exception {

        Attendance attendance = new Attendance();

        attendance.setClassSessionId(validator.instructorIdValidator(classSessionId)); // Reutiliza longValidator
        attendance.setStudentId(validator.studentsIdsValidator(studentId).get(0)); // Convierte string a long
        attendance.setAttendanceDate(LocalDate.parse(attendanceDate)); // Asumimos ISO-8601 yyyy-MM-dd
        attendance.setPresent(Boolean.parseBoolean(present));

        return attendance;
    }
}
