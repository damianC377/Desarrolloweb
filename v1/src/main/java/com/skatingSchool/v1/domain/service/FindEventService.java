package com.skatingSchool.v1.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Event;
import com.skatingSchool.v1.domain.port.FindEventPort;

@Service
public class FindEventService {

    @Autowired
    private FindEventPort findEventPort;

    public Event findById(Long eventId) throws Exception {
        Event event = findEventPort.findById(eventId);
        
        if (event == null) {
            throw new Exception("Evento con ID " + eventId + " no encontrado.");
        }
        
        return event;
    }

    public Event findByUserId(Long userId) throws Exception {
        Event event = findEventPort.findByUserId(userId);
        
        if (event == null) {
            throw new Exception("Evento con usuario ID " + userId + " no encontrado.");
        }
        
        return event;
    }

    public List<Event> findAllEvents() throws Exception {
        List<Event> events = findEventPort.findAll();
        if (events == null || events.isEmpty()) {
            throw new Exception("No se encontraron eventos.");
        }
        return events;
    }
}
