package com.skatingSchool.v1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.CreateStudentPort;
import com.skatingSchool.v1.domain.port.FindStudentPort;

@Service()
@Transactional
public class CreateStudentService {

    @Autowired
    private CreateStudentPort createStudentPort;

    @Autowired
    private FindStudentPort findStudentPort;


    public Student createStudent(Student student) throws Exception {

         if (student.getUserId() == null) {
        throw new Exception("El estudiante debe estar asociado a un usuario.");
    }

        if (findStudentPort.findByUserId(student.getUserId()) != null) {
            throw new Exception("El usuario con ID " + student.getUserId() +
                    " ya tiene un estudiante asociado.");
        }

        return createStudentPort.save(student);
    }
}

