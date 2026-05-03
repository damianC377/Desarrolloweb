package com.skatingSchool.v1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.port.CreateInstructorPort;
import com.skatingSchool.v1.domain.port.FindInstructorPort;

@Service()
@Transactional
public class CreateInstructorService {

    @Autowired
    private CreateInstructorPort createInstructorPort;

    @Autowired
    private FindInstructorPort findInstructorPort;

    public Instructor createInstructor(Instructor instructor) throws Exception {

    if (instructor.getUserId() == null) {
        throw new Exception("El instructor debe estar asociado a un usuario.");
    }

    if (findInstructorPort.findByUserId(instructor.getUserId()) != null) {
        throw new Exception("El usuario con ID " + instructor.getUserId() +
                " ya tiene un instructor asociado.");
    }

    if (instructor.getExperience() == null || instructor.getExperience().isBlank()) {
        throw new Exception("El campo 'experience' no puede estar vacío.");
    }

    return createInstructorPort.save(instructor);
}

}
