package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.port.CreateInstructorPort;
import com.skatingSchool.v1.domain.port.FindInstructorPort;

public class CreateInstructorService {

    CreateInstructorPort createInstructorPort;
    FindInstructorPort findInstructorPort;

    public void createInstructor(Instructor instructor, Long userId) throws Exception {

        instructor.setUserId(userId);

        if(findInstructorPort.findByUser(userId) != null) {
            throw new Exception("El usuario con ID " + userId + " ya es asociado.");
        }

        if (instructor.getExperience() == null || instructor.getExperience().isBlank()) {
            throw new Exception("El campo 'experience' no puede estar vacío.");
        }

        createInstructorPort.save(instructor);
    }
}
