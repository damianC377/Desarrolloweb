package com.skatingSchool.v1.adapter.in.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skatingSchool.v1.application.usecases.ClassUseCase;
import com.skatingSchool.v1.domain.model.Class;

import java.util.List;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class ClassController {

    private final ClassUseCase classUseCase;

    // OBTENER TODAS LAS CLASES (HORARIOS)
    @GetMapping
    public ResponseEntity<List<Class>> getAllClasses() {
        return ResponseEntity.ok(classUseCase.getAllClasses());
    }

}