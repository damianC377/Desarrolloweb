package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.port.CreateClassPort;
import com.skatingSchool.v1.domain.port.FindClassPort;

import java.util.List;

public class CreateClassService {

    CreateClassPort createClassPort;
    FindClassPort findClassPort;

    public void createClass(Class skatingClass) throws Exception {

        if (skatingClass.getClassName() == null || skatingClass.getClassName().isBlank()) {
            throw new Exception("El campo 'className' no puede estar vacío.");
        }

        if (skatingClass.getLevel() == null || skatingClass.getLevel().isBlank()) {
            throw new Exception("El campo 'level' no puede estar vacío.");
        }

        if (skatingClass.getSchedule() == null) {
            throw new Exception("El campo 'schedule' no puede estar vacío.");
        }

        if (skatingClass.getInstructorId() == null) {
            throw new Exception("La clase debe tener un instructor asociado.");
        }

        List<Class> instructorClasses = findClassPort.findByInstructorId(skatingClass.getInstructorId());

        for (Class existingClass : instructorClasses) {
            if (existingClass.getSchedule().equals(skatingClass.getSchedule())) {
                throw new Exception(
                        "El instructor con ID " +
                        skatingClass.getInstructorId() +
                        " ya tiene una clase programada en este horario."
                );
            }
        }

        createClassPort.save(skatingClass);
    }
}
