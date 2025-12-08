package com.skatingSchool.v1.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.skatingSchool.v1.domain.port.CreateEventPort;
import com.skatingSchool.v1.domain.port.FindEventPort;
import com.skatingSchool.v1.domain.model.Event;


@Service
public class CreateEventService {

    @Autowired
    private CreateEventPort createEventPort;

    @Autowired
    private FindEventPort findEventPort;

    public Event createEvent(Event event) throws Exception {

        if (findEventPort.findById(event.getEventId()) != null) {
            throw new Exception("Evento con ID " + event.getEventId() + " ya existe");
        }

        return createEventPort.save(event);
    }
}
