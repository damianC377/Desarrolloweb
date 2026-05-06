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

import com.skatingSchool.v1.adapter.rest.mapper.StudentRestMapper;
import com.skatingSchool.v1.adapter.rest.request.EventRequest;
import com.skatingSchool.v1.adapter.rest.request.UserResquest;
import com.skatingSchool.v1.adapter.rest.response.EventResponse;

import com.skatingSchool.v1.adapter.rest.response.StudentResponse;
import com.skatingSchool.v1.adapter.rest.response.UserResponse;
import com.skatingSchool.v1.domain.model.Event;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.model.User;

import com.skatingSchool.v1.domain.model.enums.Rol;

import org.springframework.security.core.context.SecurityContextHolder;

import com.skatingSchool.v1.adapter.rest.mapper.UserRestMapper;
import com.skatingSchool.v1.application.usecases.UserUseCase;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/v1/administrative")
public class AdministrativeController {

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    @Autowired
    private StudentRestMapper studentRestMapper;

    @Autowired
    private UserUseCase userUseCase;

    @Autowired
    private UserRestMapper userRestMapper;


    @Autowired
    private EventRestMapper eventRestMapper;


    @GetMapping("/students")
    public ResponseEntity<List<StudentResponse>> findAllStudents() throws Exception {
        List<Student> students = administrativeUseCase.findAllStudents();

        List<StudentResponse> response = students.stream()
                .map(studentRestMapper::toResponse)
                .toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

@PostMapping("/instructors")
public ResponseEntity<Map<String, Object>> createInstructor(@RequestBody UserResquest request) throws Exception {

    User user = userRestMapper.toDomain(request);

    user.setRol(Rol.INSTRUCTOR);

    Long instructorId = userUseCase.createUserInstructor(user, request.getExperience());

    UserResponse userResponse = userRestMapper.toResponse(user);

    Map<String, Object> response = new HashMap<>();
    response.put("user", userResponse);
    response.put("instructorId", instructorId);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
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