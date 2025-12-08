package com.skatingSchool.v1.adapter.out.persistence;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skatingSchool.v1.domain.model.Event;
import com.skatingSchool.v1.domain.port.CreateEventPort;
import com.skatingSchool.v1.domain.port.FindEventPort;
import com.skatingSchool.v1.infraestructure.persistence.entities.EventEntity;
import com.skatingSchool.v1.infraestructure.persistence.mapper.EventMapper;
import com.skatingSchool.v1.infraestructure.persistence.repository.EventRepository;


@Service
public class EventAdapter implements CreateEventPort, FindEventPort {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        EventEntity eventEntity = EventMapper.toEntity(event);
        EventEntity savedEntity = eventRepository.save(eventEntity);
        return EventMapper.toDomain(savedEntity);
        
    }

    @Override
    public Event findById(Long id) {
        EventEntity entity = eventRepository.findByEventId(id);
        return EventMapper.toDomain(entity);
    }

    @Override
    public Event findByUserId(Long userId) {
        EventEntity entity = eventRepository.findByUserId(userId);
        return EventMapper.toDomain(entity);
    }

    @Override
    public List<Event> findAll() {
        List<EventEntity> entities = eventRepository.findAll();
        return entities.stream()
                .map(EventMapper::toDomain)
                .toList();
    }

}
