package com.skatingSchool.v1.adapter.rest.request;

public class ClassRequest {

    private String className;
    private String level;
    private String schedule;       // Formato ISO-8601
    private String instructorId;
    private String studentsIds;    // Opcional, IDs separados por coma

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getStudentsIds() {
        return studentsIds;
    }

    public void setStudentsIds(String studentsIds) {
        this.studentsIds = studentsIds;
    }
}
