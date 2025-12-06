package com.skatingSchool.v1.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.FindStudentPort;

@Service
public class FindStudentService {

    @Autowired
    private FindStudentPort findStudentPort;

    public Student findById(Long studentId) throws Exception {
        Student student = findStudentPort.findById(studentId);
        
        if (student == null) {
            throw new Exception("Estudiante con ID " + studentId + " no encontrado.");
        }
        
        return student;
    }

    public Student findByUserId(Long userId) throws Exception {
        Student student = findStudentPort.findByUserId(userId);
        
        if (student == null) {
            throw new Exception("Estudiante con usuario ID " + userId + " no encontrado.");
        }
        
        return student;
    }
}