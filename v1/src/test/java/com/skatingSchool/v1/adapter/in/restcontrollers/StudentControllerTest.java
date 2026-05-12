package com.skatingSchool.v1.adapter.in.restcontrollers;

import com.skatingSchool.v1.adapter.rest.mapper.StudentRestMapper;
import com.skatingSchool.v1.adapter.rest.response.StudentResponse;
import com.skatingSchool.v1.application.usecases.StudentUseCase;
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

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentUseCase studentUseCase;

    @MockBean
    private StudentRestMapper studentRestMapper;

    @Test
    @WithMockUser(roles = "ADMIN")
    void getStudentsByClass_ShouldReturn200() throws Exception {

        // Objeto de dominio simulado
        Student student = new Student();

        // DTO de respuesta simulado
        StudentResponse response = new StudentResponse();

        // Cuando el caso de uso busque estudiantes de la clase 1,
        // devolverá una lista con un estudiante
        when(studentUseCase.findbyByClassId(1L))
                .thenReturn(List.of(student));

        // Cuando el mapper convierta el estudiante a DTO,
        // devolverá el objeto response
        when(studentRestMapper.toResponse(student))
                .thenReturn(response);

        // Simula una petición GET al endpoint del controlador
        mockMvc.perform(get("/api/v1/students/class/1"))
                // Verifica que la respuesta sea HTTP 200 OK
                .andExpect(status().isOk())
                // Verifica que el arreglo JSON tenga un elemento
                .andExpect(jsonPath("$.length()").value(1));
    }
}