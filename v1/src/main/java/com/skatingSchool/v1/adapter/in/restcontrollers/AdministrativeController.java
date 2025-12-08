package com.skatingSchool.v1.adapter.in.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skatingSchool.v1.application.usecases.AdministrativeUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.skatingSchool.v1.adapter.rest.mapper.InstructorRestMapper;
import com.skatingSchool.v1.adapter.rest.mapper.StudentRestMapper;
import com.skatingSchool.v1.adapter.rest.request.InstructorRequest;
import com.skatingSchool.v1.adapter.rest.response.InstructorResponse;
import com.skatingSchool.v1.adapter.rest.response.StudentResponse;
import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.model.Student;

import java.util.List;

@RestController
@RequestMapping("/api/v1/administrative")
public class AdministrativeController {

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    @Autowired
    private InstructorRestMapper instructorRestMapper;

    @Autowired
    private StudentRestMapper studentRestMapper;

    @PostMapping("/instructors")
    public ResponseEntity<InstructorResponse> createInstructors(@RequestBody InstructorRequest request) throws Exception {
        Instructor instructor = instructorRestMapper.toDomain(request);

        administrativeUseCase.createInstructor(instructor.getExperience(), instructor.getUserId()); 

        return new ResponseEntity<>(
                instructorRestMapper.toResponse(instructor),
                HttpStatus.CREATED
        );
        
    }

     @GetMapping("/students")
    public ResponseEntity<List<StudentResponse>> findAllStudents() throws Exception {
        List<Student> students = administrativeUseCase.findAllStudents();

        List<StudentResponse> response = students.stream()
                .map(studentRestMapper::toResponse)
                .toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    

}
