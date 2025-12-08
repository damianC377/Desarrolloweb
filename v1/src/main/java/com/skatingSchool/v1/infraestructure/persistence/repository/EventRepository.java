package com.skatingSchool.v1.infraestructure.persistence.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skatingSchool.v1.infraestructure.persistence.entities.EventEntity;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    
    public EventEntity findByEventId(Long eventId);
    
    public EventEntity findByUserId(Long userId);

}
