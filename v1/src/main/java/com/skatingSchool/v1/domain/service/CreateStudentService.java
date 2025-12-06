package com.skatingSchool.v1.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.CreateStudentPort;
import com.skatingSchool.v1.domain.port.FindStudentPort;

@Service()
@Transactional
public class CreateStudentService {

    CreateStudentPort createStudentPort;
    FindStudentPort findStudentPort;

    @Autowired
    public CreateStudentService(CreateStudentPort createStudentPort, FindStudentPort findStudentPort) {
        this.createStudentPort = createStudentPort;
        this.findStudentPort = findStudentPort;
    }

    public Student createStudent(Student student) throws Exception {

        if (student.getStudentId() != null &&
                findStudentPort.findById(student.getStudentId()) != null) {
            throw new Exception("El estudiante con ID " + student.getStudentId() + " ya existe.");
        }

        if (findStudentPort.findByUserId(student.getUserId()) != null) {
            throw new Exception("El usuario con ID " + student.getUserId() +
                    " ya tiene un estudiante asociado.");
        }

        return createStudentPort.save(student);
    }
}
