package com.skatingSchool.v1.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Event;
import com.skatingSchool.v1.domain.model.Student;

import com.skatingSchool.v1.domain.service.FindStudentService;
import com.skatingSchool.v1.domain.service.CreateEventService;
import com.skatingSchool.v1.domain.service.FindEventService;


import java.util.List;

@Service
public class AdministrativeUseCase {

    @Autowired
    private FindStudentService findStudentService;

    @Autowired
    private CreateEventService createEventService;

    @Autowired
    private FindEventService findEventService;

    public List<Student> findAllStudents() throws Exception {
        return findStudentService.findAllStudents();
    }

    public void createEvent(Event event) throws Exception {
        createEventService.createEvent(event);
    }

    public List<Event> findAllEvents() throws Exception {
        return findEventService.findAllEvents();
    }
    
}
