package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.Attendance;
import com.skatingSchool.v1.infraestructure.persistence.entities.AttendanceEntity;
import com.skatingSchool.v1.infraestructure.persistence.entities.ClassEntity;
import com.skatingSchool.v1.infraestructure.persistence.entities.StudentEntity;

public class AttendanceMapper {

    public static AttendanceEntity toEntity(Attendance attendance) {
        if (attendance == null) {
            return null;
        }

        AttendanceEntity entity = new AttendanceEntity();
        entity.setAttendanceId(attendance.getAttendanceId());

        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassId(attendance.getClassSessionId());
        entity.setClassSession(classEntity);

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(attendance.getStudentId());
        entity.setStudent(studentEntity);

        entity.setAttendanceDate(attendance.getAttendanceDate());
        entity.setPresent(attendance.getPresent());

        return entity;
    }

    public static Attendance toDomain(AttendanceEntity entity) {
        if (entity == null) {
            return null;
        }

        Attendance attendance = new Attendance();
        attendance.setAttendanceId(entity.getAttendanceId());
        attendance.setClassSessionId(entity.getClassSession().getClassId());
        attendance.setStudentId(entity.getStudent().getStudentId());
        attendance.setAttendanceDate(entity.getAttendanceDate());
        attendance.setPresent(entity.getPresent());

        return attendance;
    }
}
