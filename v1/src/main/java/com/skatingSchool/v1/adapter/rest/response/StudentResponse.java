package com.skatingSchool.v1.adapter.rest.response;

public class StudentResponse {

    private Long userId;
    private Boolean active;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}
