package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Event;

public interface CreateEventPort {

    Event save(Event event);
}
