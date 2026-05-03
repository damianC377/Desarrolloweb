package com.skatingSchool.v1.adapter.rest.mapper;

import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.rest.request.InstructorRequest;
import com.skatingSchool.v1.adapter.rest.response.InstructorResponse;
import com.skatingSchool.v1.domain.model.Instructor;

@Component
public class InstructorRestMapper {

    public Instructor toDomain(InstructorRequest req) {

        if (req == null) return null;

        Instructor i = new Instructor();

        i.setUserId(Long.parseLong(req.getUserId()));

        i.setExperience(req.getExperience());

        return i;
    }

    public InstructorResponse toResponse(Instructor instructor) {

        if (instructor == null) return null;

        InstructorResponse resp = new InstructorResponse();

        resp.setUserId(instructor.getUserId());
        resp.setExperience(instructor.getExperience());

        return resp;
    }
}
