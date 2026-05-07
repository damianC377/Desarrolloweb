package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.port.FindClassPort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FindClassService {

    private final FindClassPort findClassPort;

    @Autowired
    public FindClassService(FindClassPort findClassPort) {
        this.findClassPort = findClassPort;
    }

    public Class findById(Long classId) throws Exception {
        if (classId == null) {
            throw new Exception("El ID de la clase no puede ser nulo.");
        }

        Class skatingClass = findClassPort.findById(classId);

        if (skatingClass == null) {
            throw new Exception("Clase con ID " + classId + " no encontrada.");
        }

        return skatingClass;
    }

    public List<Class> findByInstructorId(Long instructorId) throws Exception {


    if (instructorId == null) {
        throw new Exception("El ID del instructor no puede ser nulo.");
    }

    List<Class> classes = findClassPort.findByInstructorId(instructorId);

    if (classes == null || classes.isEmpty()) {
        throw new Exception("No se encontraron clases para el instructor ID " + instructorId);
    }

    return classes;
}

    public List<Class> findBySchedule(LocalDateTime schedule) throws Exception {
        if (schedule == null) {
            throw new Exception("El horario no puede ser nulo.");
        }

        List<Class> classes = findClassPort.findBySchedule(schedule);

        if (classes == null || classes.isEmpty()) {
            throw new Exception("No se encontraron clases en ese horario.");
        }

        return classes;
    }

    public List<Class> findAllClasses() throws Exception {
        List<Class> classes = findClassPort.findAllClasses();

        if (classes == null || classes.isEmpty()) {
            throw new Exception("No hay clases registradas.");
        }

        return classes;
    }

    public List<Class> findByStudentId(Long studentId) throws Exception {
    if (studentId == null) {
        throw new Exception("El ID del estudiante no puede ser nulo.");
    }

    List<Class> classes = findClassPort.findByStudentId(studentId);

    if (classes == null || classes.isEmpty()) {
        throw new Exception("No se encontraron clases para el estudiante ID " + studentId);
    }

    return classes;
}

}