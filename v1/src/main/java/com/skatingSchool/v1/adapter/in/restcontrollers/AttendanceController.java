package com.skatingSchool.v1.adapter.in.restcontrollers;

import com.skatingSchool.v1.application.usecases.AttendanceUseCase;
import com.skatingSchool.v1.adapter.rest.mapper.AttendanceRestMapper;
import com.skatingSchool.v1.adapter.rest.request.AttendanceRequest;
import com.skatingSchool.v1.domain.model.Attendance;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendances")
public class AttendanceController {

    private final AttendanceUseCase attendanceUseCase;
    private final AttendanceRestMapper attendanceRestMapper;

    public AttendanceController(AttendanceUseCase attendanceUseCase,
                                AttendanceRestMapper attendanceRestMapper) {
        this.attendanceUseCase = attendanceUseCase;
        this.attendanceRestMapper = attendanceRestMapper;
    }

    
    @PostMapping
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<?> createAttendance(@RequestBody AttendanceRequest request) {
        try {
            Attendance attendance = attendanceRestMapper.toDomain(request);
            attendanceUseCase.createAttendance(attendance);

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/bulk")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<?> createAttendances(@RequestBody List<AttendanceRequest> requests) {
        try {
            List<Attendance> attendances = requests.stream()
                    .map(request -> {
                        try {
                            return attendanceRestMapper.toDomain(request);
                        } catch (Exception e) {
                            throw new RuntimeException(e.getMessage());
                        }
                    })
                    .toList();

            attendanceUseCase.createAttendances(attendances);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Asistencias registradas correctamente");

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}