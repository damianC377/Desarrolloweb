package com.skatingSchool.v1.domain.model;

import java.time.LocalDate;

public class Attendance {

    private Long attendanceId;
    private Long classSessionId;
    private long studentId;
    private LocalDate attendanceDate;
    private Boolean present;

    public Attendance() {
    }

    public Attendance(Long attendanceId, Long classSessionId, Long studentId,
                      LocalDate attendanceDate, Boolean present) {
                        
        this.attendanceId = attendanceId;
        this.classSessionId = classSessionId;
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
        this.present = present;
    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Long getClassSessionId() {
        return classSessionId;
    }

    public void setClassSessionId(Long classSessionId) {
        this.classSessionId = classSessionId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }
}
