package com.skatingSchool.v1.adapter.rest.response;

public class StudentResponse {

    private Long studentId;
    private Boolean active;
    private Long userId;          
    private UserResponse user;    

    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserResponse getUser() {
        return user;
    }
    public void setUser(UserResponse user) {
        this.user = user;
    }
}
