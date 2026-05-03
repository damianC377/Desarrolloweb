package com.skatingSchool.v1.adapter.in.restcontrollers;

import com.skatingSchool.v1.adapter.rest.mapper.StudentRestMapper;
import com.skatingSchool.v1.adapter.rest.request.StudentRequest;
import com.skatingSchool.v1.adapter.rest.response.StudentResponse;
import com.skatingSchool.v1.application.usecases.StudentUseCase;
import com.skatingSchool.v1.domain.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    
}
