package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.Event;
import com.skatingSchool.v1.infraestructure.persistence.entities.EventEntity;

public class EventMapper {
    
    public static EventEntity toEntity(Event event) {
        if (event == null) {
            return null;
        }

        EventEntity eventEntity = new EventEntity();
        eventEntity.setEventId(event.getEventId());
        eventEntity.setTitle(event.getTitle());
        eventEntity.setDate(event.getDate());
        eventEntity.setDescription(event.getDescription());
        eventEntity.setDetails(event.getDetails());
        eventEntity.setLocation(event.getLocation());
        eventEntity.setUserId(event.getUserId());

        return eventEntity;
    }

    public static Event toDomain(EventEntity eventEntity) {
        if (eventEntity == null) {
            return null;
        }

        Event event = new Event();
        event.setEventId(eventEntity.getEventId());
        event.setTitle(eventEntity.getTitle());
        event.setDate(eventEntity.getDate());
        event.setDescription(eventEntity.getDescription());
        event.setDetails(eventEntity.getDetails());
        event.setLocation(eventEntity.getLocation());
        event.setUserId(eventEntity.getUserId());

        return event;
    }
}
