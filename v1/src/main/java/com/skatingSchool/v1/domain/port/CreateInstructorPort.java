package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Instructor;

public interface CreateInstructorPort {

    Instructor save(Instructor instructor);
}
