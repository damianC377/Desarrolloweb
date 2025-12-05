package com.skatingSchool.v1.domain.model;

public class Instructor {

    private Long instructorId;
    private Long userId;
    private String experience;

    public Instructor() {
    }

    public Instructor(Long instructorId, Long userId, String experience) {
        this.instructorId = instructorId;
        this.userId = userId;
        this.experience = experience;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

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
