package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Attendance;

public interface CreateAttendancePort {

    void save(Attendance attendance);
}
