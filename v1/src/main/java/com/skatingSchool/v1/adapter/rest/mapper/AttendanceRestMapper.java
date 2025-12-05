package com.skatingSchool.v1.adapter.rest.mapper;

import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.rest.request.AttendanceRequest;
import com.skatingSchool.v1.adapter.rest.response.AttendanceResponse;
import com.skatingSchool.v1.domain.model.Attendance;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Component
public class AttendanceRestMapper {

    public Attendance toDomain(AttendanceRequest request) throws Exception {
        if (request == null) {
            return null;
        }

        Attendance attendance = new Attendance();

        try {
            attendance.setClassSessionId(Long.parseLong(request.getClassSessionId()));
        } catch (NumberFormatException e) {
            throw new Exception("El ID de la clase debe ser un número válido");
        }

        try {
            attendance.setStudentId(Long.parseLong(request.getStudentId()));
        } catch (NumberFormatException e) {
            throw new Exception("El ID del estudiante debe ser un número válido");
        }

        try {
            attendance.setAttendanceDate(LocalDate.parse(request.getAttendanceDate()));
        } catch (DateTimeParseException e) {
            throw new Exception("La fecha de asistencia debe tener el formato yyyy-MM-dd");
        }

        if (request.getPresent() == null || request.getPresent().isBlank()) {
            throw new Exception("El campo 'present' no puede estar vacío");
        }
        attendance.setPresent(Boolean.parseBoolean(request.getPresent()));

        return attendance;
    }

    public AttendanceResponse toResponse(Attendance attendance) {
        if (attendance == null) {
            return null;
        }

        AttendanceResponse response = new AttendanceResponse();
        response.setAttendanceId(attendance.getAttendanceId());
        response.setClassSessionId(attendance.getClassSessionId());
        response.setStudentId(attendance.getStudentId());
        response.setAttendanceDate(attendance.getAttendanceDate());
        response.setPresent(attendance.getPresent());

        return response;
    }
}
