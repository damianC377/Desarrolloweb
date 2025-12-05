package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.CreateStudentPort;
import com.skatingSchool.v1.domain.port.FindStudentPort;

public class CreateStudentService {

    private final CreateStudentPort createStudentPort;
    private final FindStudentPort findStudentPort;

    public CreateStudentService(CreateStudentPort createStudentPort,
                                FindStudentPort findStudentPort) {
        this.createStudentPort = createStudentPort;
        this.findStudentPort = findStudentPort;
    }

    public void createStudent(Student student) throws Exception {

        if (student.getStudentId() != null &&
                findStudentPort.findById(student.getStudentId()) != null) {
            throw new Exception("El estudiante con ID " + student.getStudentId() + " ya existe.");
        }

        if (student.getUser() != null &&
                findStudentPort.findByUser(student.getUser().getUserid()) != null) {
            throw new Exception("El usuario con ID " + student.getUser().getUserid() +
                    " ya tiene un estudiante asociado.");
        }

        createStudentPort.save(student);
    }
}
