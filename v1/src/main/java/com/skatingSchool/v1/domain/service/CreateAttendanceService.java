package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.Attendance;
import com.skatingSchool.v1.domain.port.CreateAttendancePort;
import com.skatingSchool.v1.domain.port.FindAttendancePort;

import java.time.LocalDate;
import java.util.List;

public class CreateAttendanceService {

    private final CreateAttendancePort createAttendancePort;
    private final FindAttendancePort findAttendancePort;

    public CreateAttendanceService(CreateAttendancePort createAttendancePort,
                                   FindAttendancePort findAttendancePort) {
        this.createAttendancePort = createAttendancePort;
        this.findAttendancePort = findAttendancePort;
    }

    public void createAttendance(Attendance attendance) throws Exception {

        if (attendance.getClassSessionId() == null) {
            throw new Exception("La asistencia debe estar asociada a una clase (classSessionId).");
        }

        if (attendance.getStudentId() == 0) {
            throw new Exception("La asistencia debe estar asociada a un estudiante (studentId).");
        }

        if (attendance.getAttendanceDate() == null) {
            throw new Exception("La fecha de asistencia no puede estar vacía.");
        }

        if (attendance.getPresent() == null) {
            throw new Exception("Debe indicar si el estudiante estuvo presente o no.");
        }

        List<Attendance> existingAttendances =
                findAttendancePort.findByClassId(attendance.getClassSessionId());

        for (Attendance existing : existingAttendances) {
            if (existing.getStudentId() == attendance.getStudentId() &&
                existing.getAttendanceDate().equals(attendance.getAttendanceDate())) {
                throw new Exception(
                        "El estudiante con ID " +
                        attendance.getStudentId() +
                        " ya tiene registrada asistencia para esta clase en la fecha " +
                        attendance.getAttendanceDate()
                );
            }
        }

        createAttendancePort.save(attendance);
    }
}
