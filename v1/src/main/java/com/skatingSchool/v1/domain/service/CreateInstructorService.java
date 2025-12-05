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

    public void createInstructor(Instructor instructor) throws Exception {

        if (instructor.getInstructorId() != null &&
                findInstructorPort.findById(instructor.getInstructorId()) != null) {
            throw new Exception("El instructor con ID " + instructor.getInstructorId() + " ya existe.");
        }

        if (instructor.getUser() != null &&
                findInstructorPort.findByUser(instructor.getUser().getUserid()) != null) {
            throw new Exception("El usuario con ID "
                    + instructor.getUser().getUserid()
                    + " ya está asignado como instructor.");
        }

        if (instructor.getExperience() == null || instructor.getExperience().isBlank()) {
            throw new Exception("El campo 'experience' no puede estar vacío.");
        }

        createInstructorPort.save(instructor);
    }
}
