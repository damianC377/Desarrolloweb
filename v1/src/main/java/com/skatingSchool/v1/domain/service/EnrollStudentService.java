package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.EnrollStudentPort;
import com.skatingSchool.v1.domain.port.FindClassPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollStudentService {

    private final EnrollStudentPort enrollStudentPort;
    private final FindClassPort findClassPort;

    public EnrollStudentService(EnrollStudentPort enrollStudentPort, FindClassPort findClassPort) {
        this.enrollStudentPort = enrollStudentPort;
        this.findClassPort = findClassPort;
    }

    public void enrollStudent(Long classId, Student student) throws Exception {
        // Validar que la clase existe
        Class skatingClass = findClassPort.findById(classId);
        if (skatingClass == null) {
            throw new Exception("La clase con ID " + classId + " no existe.");
        }

        // Validar que el estudiante no esté ya inscrito
        if (enrollStudentPort.isStudentEnrolled(classId, student.getStudentId())) {
            throw new Exception("El estudiante ya está inscrito en esta clase.");
        }

        // Validar que el estudiante esté activo
        if (!student.getActive()) {
            throw new Exception("El estudiante no está activo.");
        }

        // Inscribir
        enrollStudentPort.enrollStudent(classId, student);
    }

    public List<Class> getAvailableClasses() throws Exception {
        List<Class> available = findClassPort.findClassesWithAvailableSpots();
        if (available.isEmpty()) {
            throw new Exception("No hay clases disponibles en este momento.");
        }
        return available;
    }
} 
  

