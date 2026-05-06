package com.skatingSchool.v1.application.usecases;

import org.springframework.stereotype.Component;
import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.service.FindClassService;

import java.util.List;

@Component
public class ClassUseCase {

    private final FindClassService findClassService;

    public ClassUseCase(FindClassService findClassService) {
        this.findClassService = findClassService;
    }

    // MÉTODO PARA TRAER TODAS LAS CLASES
    public List<Class> getAllClasses() {
        return findClassService.execute();
    }
}