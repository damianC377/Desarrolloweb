package com.skatingSchool.v1.domain.model;

public class Student {

    private Long studentId;
    private long UserId;
    private Boolean active;

    public Student() {
    }

    public Student(Long studentId, long UserId, Boolean active) {
        this.studentId = studentId;
        this.UserId = UserId;
        this.active = active;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(long UserId) {
        this.UserId = UserId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
