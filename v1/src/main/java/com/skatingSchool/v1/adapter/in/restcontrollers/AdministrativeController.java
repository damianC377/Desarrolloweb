package com.skatingSchool.v1.adapter.in.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skatingSchool.v1.application.usecases.AdministrativeUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.skatingSchool.v1.adapter.rest.mapper.InstructorRestMapper;
import com.skatingSchool.v1.adapter.rest.request.InstructorRequest;
import com.skatingSchool.v1.adapter.rest.response.InstructorResponse;
import com.skatingSchool.v1.domain.model.Instructor;

@RestController
@RequestMapping("/api/v1/administrative")
public class AdministrativeController {

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    @Autowired
    private InstructorRestMapper instructorRestMapper;

    @PostMapping("/instructors")
    public ResponseEntity<InstructorResponse> createInstructors(@RequestBody InstructorRequest request) throws Exception {
        Instructor instructor = instructorRestMapper.toDomain(request);

        administrativeUseCase.createInstructor(instructor.getExperience(), instructor.getUserId()); 

        return new ResponseEntity<>(
                instructorRestMapper.toResponse(instructor),
                HttpStatus.CREATED
        );
        
    }

}
