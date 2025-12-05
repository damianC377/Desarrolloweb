package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Class;

import java.time.LocalDateTime;
import java.util.List;

public interface FindClassPort {

    Class findById(Long classId);

    List<Class> findByInstructorId(Long instructorId);

    List<Class> findBySchedule(LocalDateTime schedule);

}
