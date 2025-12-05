package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.port.CreateInstructorPort;
import com.skatingSchool.v1.domain.port.FindInstructorPort;

public class CreateInstructorService {

    private final CreateInstructorPort createInstructorPort;
    private final FindInstructorPort findInstructorPort;

    public CreateInstructorService(CreateInstructorPort createInstructorPort,
                                   FindInstructorPort findInstructorPort) {
        this.createInstructorPort = createInstructorPort;
        this.findInstructorPort = findInstructorPort;
    }

    public void createInstructor(Instructor instructor, Long userId) throws Exception {

        instructor.setUserId(userId);

        if (instructor.getInstructorId() != null &&
                findInstructorPort.findById(instructor.getInstructorId()) != null) {
            throw new Exception("El instructor con ID " + instructor.getInstructorId() + " ya existe.");
        }

        if(findInstructorPort.findByUser(userId) != null) {
            throw new Exception("El usuario con ID " + userId + " ya es asociado.");
        }

        if (instructor.getExperience() == null || instructor.getExperience().isBlank()) {
            throw new Exception("El campo 'experience' no puede estar vacío.");
        }

        createInstructorPort.save(instructor);
    }
}
