package com.skatingSchool.v1.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.builder.EventBuilder;
import com.skatingSchool.v1.adapter.rest.request.EventRequest;
import com.skatingSchool.v1.adapter.rest.response.EventResponse;
import com.skatingSchool.v1.domain.model.Event;

@Component
public class EventRestMapper {

    @Autowired
    private EventBuilder eventBuilder;

    public Event toDomain(EventRequest req) throws Exception {
        if(req == null){
            return null;
        }

        Event e = eventBuilder.build(
            req.getTitle(),
            req.getDate(),
            req.getDescription(),
            req.getDetails(),
            req.getLocation(),
            req.getUserId()
        );

        return e;        
    }

    public EventResponse toResponse(Event event) {
        if(event == null){
            return null;
        }

        EventResponse resp = new EventResponse();
        resp.setTitle(event.getTitle());
        resp.setDate(event.getDate());
        resp.setDescription(event.getDescription());
        resp.setDetails(event.getDetails());
        resp.setLocation(event.getLocation());
        resp.setUserId(event.getUserId());

        return resp;
    }
}
