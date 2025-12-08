package com.skatingSchool.v1.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.domain.model.Event;
import com.skatingSchool.v1.adapter.in.validator.EventValidator;

@Component
public class EventBuilder {

    @Autowired
    private EventValidator validator;

    public EventBuilder() {
        this.validator = new EventValidator();
    }

    public Event build(String title, String date, String description, String details, String location, String userId) throws Exception {
        Event event = new Event();
        event.setTitle(validator.eventTitleValidator(title));
        event.setDate(validator.eventDateValidator(date));
        event.setDescription(validator.eventDescriptionValidator(description));
        event.setLocation(validator.eventLocationValidator(location));
        event.setUserId(validator.eventUserIdValidator(userId));
        
        return event;
    }

}
