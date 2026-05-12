package com.skatingSchool.v1.adapter.in.restcontrollers;

import com.skatingSchool.v1.adapter.rest.mapper.StudentRestMapper;
import com.skatingSchool.v1.adapter.rest.mapper.UserRestMapper;
import com.skatingSchool.v1.adapter.rest.mapper.EventRestMapper;
import com.skatingSchool.v1.adapter.rest.response.StudentResponse;
import com.skatingSchool.v1.application.usecases.AdministrativeUseCase;
import com.skatingSchool.v1.application.usecases.UserUseCase;
import com.skatingSchool.v1.domain.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdministrativeController.class)
class AdministrativeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdministrativeUseCase administrativeUseCase;

    @MockBean
    private StudentRestMapper studentRestMapper;

    @MockBean
    private UserUseCase userUseCase;

    @MockBean
    private UserRestMapper userRestMapper;

    @MockBean
    private EventRestMapper eventRestMapper;

    @Test
    @WithMockUser(roles = "ADMIN")
    void findAllStudents_ShouldReturn200() throws Exception {

        Student student = new Student();
        StudentResponse response = new StudentResponse();

        when(administrativeUseCase.findAllStudents())
                .thenReturn(List.of(student));

        when(studentRestMapper.toResponse(student))
                .thenReturn(response);

        mockMvc.perform(get("/api/v1/administrative/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}