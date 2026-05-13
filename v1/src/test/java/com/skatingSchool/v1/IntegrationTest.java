package com.skatingSchool.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.skatingSchool.v1.adapter.rest.request.ClassRequest;
import com.skatingSchool.v1.adapter.rest.request.PaymentRequest;
import com.skatingSchool.v1.adapter.rest.request.UserResquest;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@SuppressWarnings("null")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)  


public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Registrar estudiante
    @Test
    void shouldRegisterStudent() throws Exception {
        UserResquest request = new UserResquest();
        
        request.setDocument("123456789");
        request.setName("Manuela");
        request.setLastname("Gomez");
        request.setEmail("manuela.gomez@test.com");
        request.setPhone("3001234567");
        request.setAddress("Medellin");
        request.setUsername("manuelagomez");
        request.setPassword("Clave123");

        mockMvc.perform(post("/api/v1/users/register-student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.studentId").exists())
                .andExpect(jsonPath("$.user.name").value("Manuela"));
    }

    // Registrar instructor
    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldCreateInstructor() throws Exception {
        UserResquest request = new UserResquest();
        
        request.setDocument("999888777");
        request.setName("Luis");
        request.setLastname("Fernandez");
        request.setEmail("luis.fernandez@test.com");
        request.setPhone("3155554444");
        request.setAddress("Cali");
        request.setUsername("luisfer");
        request.setPassword("Clave789");
        request.setExperience("10 años enseñando patinaje");

        mockMvc.perform(post("/api/v1/administrative/instructors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.instructorId").exists())
                .andExpect(jsonPath("$.user.name").value("Luis"));
    }
    
    // Crear clase
    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldCreateClass() throws Exception {
        UserResquest instructor = new UserResquest();

        instructor.setDocument("839398493");
        instructor.setName("Maria");
        instructor.setLastname("Torres");
        instructor.setEmail("maria.torres@test.com");
        instructor.setPhone("322111222");
        instructor.setAddress("Barranquilla");
        instructor.setUsername("mariatorres");
        instructor.setPassword("Clave321");
        instructor.setExperience("8 años enseñando");

        String instructorResponse = mockMvc.perform(post("/api/v1/administrative/instructors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(instructor)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long instructorId = objectMapper.readTree(instructorResponse)
                .get("instructorId")
                .asLong();

        ClassRequest request = new ClassRequest();
        request.setClassName("Patinaje avanzado nivel 3");
        request.setLevel("Advanced");
        request.setSchedule("2026-06-15T14:00:00");
        request.setInstructorId(String.valueOf(instructorId));

        mockMvc.perform(post("/api/v1/classes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }
    
    // Obtener todas las clases
    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetAllClasses() throws Exception {
        UserResquest instructor = new UserResquest();
        
        instructor.setDocument("9012345678");
        instructor.setName("Lina");
        instructor.setLastname("Guzman");
        instructor.setEmail("lina.guzman@test.com");
        instructor.setPhone("3125557890");
        instructor.setAddress("Armenia");
        instructor.setUsername("linag");
        instructor.setPassword("ClaveLina1");
        instructor.setExperience("3 años");

        String instructorResponse = mockMvc.perform(post("/api/v1/administrative/instructors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(instructor)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long instructorId = objectMapper.readTree(instructorResponse)
                .get("instructorId")
                .asLong();

        ClassRequest classRequest = new ClassRequest();
        classRequest.setClassName("Patinaje recreativo");
        classRequest.setLevel("Beginner");
        classRequest.setSchedule("2026-10-25T09:00:00");
        classRequest.setInstructorId(String.valueOf(instructorId));

        mockMvc.perform(post("/api/v1/classes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(classRequest)))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/api/v1/classes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    // Registrar pago
    @Test
    void shouldRegisterPayment() throws Exception {
        UserResquest student = new UserResquest();
        
        student.setDocument("444555666");  
        student.setName("Carlos");
        student.setLastname("Sanchez");
        student.setEmail("carlos.sanchez@test.com");
        student.setPhone("3112223334");
        student.setAddress("Cartagena");
        student.setUsername("carlossanchez");
        student.setPassword("Clave555");

        String studentResponse = mockMvc.perform(post("/api/v1/users/register-student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long studentId = objectMapper.readTree(studentResponse)
                .get("studentId")
                .asLong();

        PaymentRequest request = new PaymentRequest();
        request.setStudentId(String.valueOf(studentId));
        request.setPaymentDate("2026-06-10");
        request.setAmount("250000");
        request.setPaymentMethod("Bancolombia");

        mockMvc.perform(post("/api/v1/payments/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.paymentMethod").value("Bancolombia"));
    }
}