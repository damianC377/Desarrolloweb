package com.skatingSchool.v1.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Class {

    private Long classId;
    private String className;
    private String level;
    private LocalDateTime schedule;
    private long instructorId;
    private List<Student> students;

    public Class() {
    }

    public Class(Long classId, String className, String level, LocalDateTime schedule,
                 Long instructorId, List<Student> students) {
        this.classId = classId;
        this.className = className;
        this.level = level;
        this.schedule = schedule;
        this.instructorId = instructorId;
        this.students = students;
    }

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

    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
