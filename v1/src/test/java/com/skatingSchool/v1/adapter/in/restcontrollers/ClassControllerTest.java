package com.skatingSchool.v1.adapter.in.restcontrollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skatingSchool.v1.adapter.rest.mapper.ClassRestMapper;
import com.skatingSchool.v1.adapter.rest.request.ClassRequest;
import com.skatingSchool.v1.application.usecases.ClassUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClassController.class)
class ClassControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClassUseCase classUseCase;

    @MockBean
    private ClassRestMapper classRestMapper;

    @Test
    @WithMockUser(roles = "ADMIN")
    void createClass_ShouldReturn201() throws Exception {

        ClassRequest request = new ClassRequest();
        com.skatingSchool.v1.domain.model.Class domainClass =
                new com.skatingSchool.v1.domain.model.Class();

        when(classRestMapper.toDomain(any(ClassRequest.class)))
                .thenReturn(domainClass);

        doNothing().when(classUseCase)
                .createClass(domainClass);

        mockMvc.perform(post("/api/v1/classes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Clase creada correctamente"));
    }
}