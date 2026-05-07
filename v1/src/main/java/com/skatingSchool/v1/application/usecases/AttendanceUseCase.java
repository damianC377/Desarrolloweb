package com.skatingSchool.v1.application.usecases;

import com.skatingSchool.v1.domain.model.Attendance;
import com.skatingSchool.v1.domain.service.CreateAttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceUseCase {

    @Autowired
    private CreateAttendanceService createAttendanceService;

    public void createAttendance(Attendance attendance) throws Exception {
        createAttendanceService.createAttendance(attendance);
    }

    public void createAttendances(List<Attendance> attendances) throws Exception {
        createAttendanceService.createAttendances(attendances);
    }
}