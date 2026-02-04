package com.skatingSchool.v1.adapter.in.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import com.skatingSchool.v1.application.usecases.AdministrativeUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skatingSchool.v1.adapter.rest.mapper.EventRestMapper;
import com.skatingSchool.v1.adapter.rest.mapper.InstructorRestMapper;
import com.skatingSchool.v1.adapter.rest.mapper.StudentRestMapper;
import com.skatingSchool.v1.adapter.rest.request.EventRequest;
import com.skatingSchool.v1.adapter.rest.request.InstructorRequest;
import com.skatingSchool.v1.adapter.rest.response.EventResponse;
import com.skatingSchool.v1.adapter.rest.response.InstructorResponse;
import com.skatingSchool.v1.adapter.rest.response.StudentResponse;
import com.skatingSchool.v1.domain.model.Event;
import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.model.Student;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/v1/administrative")
public class AdministrativeController {

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    @Autowired
    private InstructorRestMapper instructorRestMapper;

    @Autowired
    private StudentRestMapper studentRestMapper;

    @Autowired
    private EventRestMapper eventRestMapper;

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

    @PostMapping("/events")
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest request) throws Exception {

        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();

        request.setUserId(String.valueOf(userId));

        Event entity = eventRestMapper.toDomain(request);

        administrativeUseCase.createEvent(entity);
        
        return new ResponseEntity<>(eventRestMapper.toResponse(entity), HttpStatus.CREATED);
    }
    

    @GetMapping("/showevents")
    public ResponseEntity<List<EventResponse>> findAllEvents() throws Exception {
        List<Event> events = administrativeUseCase.findAllEvents();

        List<EventResponse> response = events.stream()
                .map(eventRestMapper::toResponse)
                .toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}