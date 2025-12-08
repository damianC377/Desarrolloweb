package com.skatingSchool.v1.domain.port;

import java.util.List;

import com.skatingSchool.v1.domain.model.Event;

public interface FindEventPort {

    Event findById(Long eventId);
    
    Event findByTitle(String title);

    Event findByUserId(Long userId);

    List<Event> findAll();
}
