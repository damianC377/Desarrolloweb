package com.skatingSchool.v1.adapter.in.restcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.skatingSchool.v1.adapter.rest.mapper.ClassRestMapper;
import com.skatingSchool.v1.adapter.rest.request.ClassRequest;
import com.skatingSchool.v1.application.usecases.ClassUseCase;
import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.model.Student;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")

public class ClassController {

    @Autowired
    private ClassRestMapper classRestMapper;

    @Autowired
    private ClassUseCase classUseCase;

    // CREAR CLASE
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createClass(@RequestBody ClassRequest request) {
        try {
            Class skatingClass = classRestMapper.toDomain(request);
            classUseCase.createClass(skatingClass);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Clase creada correctamente");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // OBTENER TODAS LAS CLASES (HORARIOS)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    public ResponseEntity<?> getAllClasses() {
        try {
            List<Class> classes = classUseCase.getAllClasses();
            return ResponseEntity.ok(classes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // VER UNA CLASE POR ID
    @GetMapping("/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR','STUDENT')")
    public ResponseEntity<?> getClassById(@PathVariable Long classId) {
        try {
            Class skatingClass = classUseCase.getClassById(classId);
            return ResponseEntity.ok(skatingClass);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // VER CLASES DISPONIBLES
    @GetMapping("/available")
    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR','STUDENT')")
    public ResponseEntity<?> getAvailableClasses() {
        try {
            List<Class> classes = classUseCase.getAvailableClasses();
            return ResponseEntity.ok(classes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // VER CLASES POR ESTUDIANTE
    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    public ResponseEntity<?> getClassesByStudent(@PathVariable Long studentId) {
        try {
            List<Class> classes = classUseCase.getClassesByStudent(studentId);
            return ResponseEntity.ok(classes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // INSCRIBIRSE A UNA CLASE
    @PostMapping("/{classId}/enroll")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<?> enrollStudent(@PathVariable Long classId, @RequestBody Student student) {
        try {
            classUseCase.enrollStudent(classId, student);
            return ResponseEntity.ok("Estudiante inscrito exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}