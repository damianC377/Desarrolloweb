package com.skatingSchool.v1.adapter.rest.request;

public class StudentRequest {

    private String userId;
    private String active;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }
}
