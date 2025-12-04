package com.skatingSchool.v1.domain.model;

import java.time.LocalDate;

public class Attendance {

    private Long attendanceId;
    private Class classSession;
    private Student student;
    private LocalDate attendanceDate;
    private Boolean present;

    public Attendance() {
    }

    public Attendance(Long attendanceId, Class classSession, Student student,
                      LocalDate attendanceDate, Boolean present) {
                        
        this.attendanceId = attendanceId;
        this.classSession = classSession;
        this.student = student;
        this.attendanceDate = attendanceDate;
        this.present = present;
    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Class getClassSession() {
        return classSession;
    }

    public void setClassSession(Class classSession) {
        this.classSession = classSession;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
