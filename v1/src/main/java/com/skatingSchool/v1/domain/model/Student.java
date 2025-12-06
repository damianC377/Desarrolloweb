package com.skatingSchool.v1.domain.model;

public class Student {

    private Long studentId;
    private long userId;
    private Boolean active;

    public Student() {
    }

    public Student(Long studentId, long userId, Boolean active) {
        this.studentId = studentId;
        this.userId = userId;
        this.active = active;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Boolean getActive() {
        return active != null ? active : false;  // ← Nunca retornar null
    }

    public void setActive(Boolean active) {
        this.active = active != null ? active : false;  // ← Nunca asignar null
    }

}
