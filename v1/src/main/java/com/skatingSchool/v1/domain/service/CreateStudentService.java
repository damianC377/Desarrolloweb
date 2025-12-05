package com.skatingSchool.v1.domain.service;

import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.CreateStudentPort;
import com.skatingSchool.v1.domain.port.FindStudentPort;

@Service()
public class CreateStudentService {

    CreateStudentPort createStudentPort;
    FindStudentPort findStudentPort;

    public void createStudent(Student student) throws Exception {

        if (student.getStudentId() != null &&
                findStudentPort.findById(student.getStudentId()) != null) {
            throw new Exception("El estudiante con ID " + student.getStudentId() + " ya existe.");
        }

        if (findStudentPort.findByUserId(student.getUserId()) != null) {
            throw new Exception("El usuario con ID " + student.getUserId() +
                    " ya tiene un estudiante asociado.");
        }

        createStudentPort.save(student);
    }
}
