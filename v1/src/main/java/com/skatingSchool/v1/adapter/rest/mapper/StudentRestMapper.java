package com.skatingSchool.v1.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.builder.Studentbuilder;
import com.skatingSchool.v1.adapter.rest.response.StudentResponse;
import com.skatingSchool.v1.adapter.rest.request.StudentRequest;
import com.skatingSchool.v1.adapter.rest.response.UserResponse;
import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.service.FindUserService;

@Component
public class StudentRestMapper {

    @Autowired
    private Studentbuilder studentbuilder;

    @Autowired
    private UserRestMapper userRestMapper;

    @Autowired
    private FindUserService findUserService;

    public Student toDomain(StudentRequest req) throws Exception {
        if (req == null) return null;

        return studentbuilder.build(req.getUserId());
    }

    public StudentResponse toResponse(Student student) {
        if (student == null) return null;

        StudentResponse resp = new StudentResponse();
        
        // Campos del estudiante
        resp.setStudentId(student.getStudentId());
        resp.setActive(student.getActive());
        resp.setUserId(student.getUserId());

        try {
            // Buscar el usuario relacionado
            User user = findUserService.findById(student.getUserId());
            UserResponse userResp = userRestMapper.toResponse(user);

            // Agregarlo al response
            resp.setUser(userResp);
        } catch (Exception e) {
            resp.setUser(null); 
        }

        return resp;
    }
}
