package com.skatingSchool.v1.domain.model;

public class Student {

    private Long studentId;
    private User user;
    private Boolean active;

    public Student() {
    }

    public Student(Long studentId, User user, Boolean active) {
        this.studentId = studentId;
        this.user = user;
        this.active = active;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
