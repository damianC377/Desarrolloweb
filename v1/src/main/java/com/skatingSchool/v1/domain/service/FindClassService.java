package com.skatingSchool.v1.domain.service;

import org.springframework.stereotype.Service;
import com.skatingSchool.v1.domain.port.FindClassPort;
import com.skatingSchool.v1.domain.model.Class;

import java.util.List;

@Service
public class FindClassService {

    private final FindClassPort findClassPort;

    public FindClassService(FindClassPort findClassPort) {
        this.findClassPort = findClassPort;
    }

    public List<Class> execute() {
        return findClassPort.findAllClasses();
    }
}