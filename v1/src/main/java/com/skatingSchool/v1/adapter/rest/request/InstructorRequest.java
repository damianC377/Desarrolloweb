package com.skatingSchool.v1.adapter.rest.request;

public class InstructorRequest {

    private String userId;
    private String experience;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
