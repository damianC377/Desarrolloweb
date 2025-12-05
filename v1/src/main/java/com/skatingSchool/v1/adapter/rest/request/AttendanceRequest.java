package com.skatingSchool.v1.adapter.rest.request;

public class AttendanceRequest {

    private String classSessionId; // ID de la clase
    private String studentId;      // ID del estudiante
    private String attendanceDate; // Formato ISO-8601: yyyy-MM-dd
    private String present;        // "true" o "false"

    public String getClassSessionId() {
        return classSessionId;
    }

    public void setClassSessionId(String classSessionId) {
        this.classSessionId = classSessionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }
}
