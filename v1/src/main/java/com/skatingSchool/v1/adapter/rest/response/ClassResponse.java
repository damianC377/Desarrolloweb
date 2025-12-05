package com.skatingSchool.v1.adapter.rest.response;

import java.time.LocalDateTime;
import java.util.List;

public class ClassResponse {

    private Long classId;
    private String className;
    private String level;
    private LocalDateTime schedule;
    private Long instructorId;
    private List<Long> studentsIds;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

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

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public List<Long> getStudentsIds() {
        return studentsIds;
    }

    public void setStudentsIds(List<Long> studentsIds) {
        this.studentsIds = studentsIds;
    }
}
