package com.skatingSchool.v1.adapter.rest.response;

public class InstructorResponse {

    private Long userId;
    private String experience;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
