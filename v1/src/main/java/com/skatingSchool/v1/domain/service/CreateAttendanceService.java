package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.Attendance;
import com.skatingSchool.v1.domain.port.CreateAttendancePort;
import com.skatingSchool.v1.domain.port.FindAttendancePort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAttendanceService {

    @Autowired
    private CreateAttendancePort createAttendancePort;
    @Autowired
    private FindAttendancePort findAttendancePort;
   

    public void createAttendance(Attendance attendance) throws Exception {

        if (attendance.getClassSessionId() == null) {
            throw new Exception("La asistencia debe estar asociada a una clase.");
        }

        if (attendance.getStudentId() == 0) {
            throw new Exception("La asistencia debe estar asociada a un estudiante.");
        }

        if (attendance.getAttendanceDate() == null) {
            throw new Exception("La fecha de asistencia no puede estar vacía.");
        }

        if (attendance.getPresent() == null) {
            throw new Exception("Debe indicar si el estudiante estuvo presente o no.");
        }

        // 🔥 VALIDACIÓN OPTIMIZADA
        List<Attendance> existingAttendances =
                findAttendancePort.findByClassIdAndDate(
                        attendance.getClassSessionId(),
                        attendance.getAttendanceDate()
                );

        for (Attendance existing : existingAttendances) {
            if (existing.getStudentId() == attendance.getStudentId()) {
                throw new Exception(
                        "El estudiante con ID " +
                        attendance.getStudentId() +
                        " ya tiene asistencia registrada en esta fecha."
                );
            }
        }

        createAttendancePort.save(attendance);
    }

  
    public void createAttendances(List<Attendance> attendances) throws Exception {

        if (attendances == null || attendances.isEmpty()) {
            throw new Exception("La lista de asistencias no puede estar vacía.");
        }

        for (Attendance attendance : attendances) {
            createAttendance(attendance);
        }
    }
}