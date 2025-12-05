package com.skatingSchool.v1.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.builder.Instructorbuilder;
import com.skatingSchool.v1.adapter.rest.request.InstructorRequest;
import com.skatingSchool.v1.adapter.rest.response.InstructorResponse;
import com.skatingSchool.v1.domain.model.Instructor;

@Component
public class InstructorRestMapper {

    @Autowired
    private Instructorbuilder instructorbuilder;


    public Instructor toDomain(InstructorRequest req) throws Exception {
        if(req == null){
            return null;
        }

        Instructor i = instructorbuilder.build(
           req.getUserId(),
           req.getExperience()

        );

        return i;

    }

    public InstructorResponse toResponse(Instructor instructor) {
        if(instructor == null){
            return null;
        }

        InstructorResponse resp = new InstructorResponse();
        resp.setUserId(instructor.getUserId());
        resp.setExperience(instructor.getExperience());

        return resp;

    }
    


    
}
