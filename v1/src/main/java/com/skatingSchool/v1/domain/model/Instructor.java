package com.skatingSchool.v1.domain.model;

public class Instructor {

    private Long instructorId;
    private User user;
    private String experience;

    public Instructor() {
    }

    public Instructor(Long instructorId, User user, String experience) {
        this.instructorId = instructorId;
        this.user = user;
        this.experience = experience;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
