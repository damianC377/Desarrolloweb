package com.skatingSchool.v1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.CreateStudentPort;
import com.skatingSchool.v1.domain.port.FindStudentPort;

@Service
public class CreateStudentService {

    @Autowired
    private CreateStudentPort createStudentPort;

    @Autowired
    private FindStudentPort findStudentPort;

    public void createStudent(Student student) throws Exception {
        // Verificar si ya existe un estudiante para ese usuario
        Student existing = findStudentPort.findByUserId(student.getUserId());
        if (existing != null) {
            throw new Exception("Ya existe un estudiante asociado a este usuario");
        }

        // Guardar el estudiante
        createStudentPort.save(student);
    }
}

