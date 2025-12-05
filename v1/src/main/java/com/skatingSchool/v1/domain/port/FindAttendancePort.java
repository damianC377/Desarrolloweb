package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface FindAttendancePort {

    Attendance findById(Long attendanceId);

    List<Attendance> findByClassId(Long classId);

    List<Attendance> findByStudentId(Long studentId);

    List<Attendance> findByDate(LocalDate date);

}
