package com.skatingSchool.v1.adapter.in.restcontrollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skatingSchool.v1.adapter.rest.mapper.AuthRestMapper;
import com.skatingSchool.v1.adapter.rest.request.AuthRequest;
import com.skatingSchool.v1.adapter.rest.response.TokenResponseDto;
import com.skatingSchool.v1.application.usecases.LoginUseCase;
import com.skatingSchool.v1.domain.model.auth.AuthCredentials;
import com.skatingSchool.v1.domain.model.auth.TokenResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Verifica que el controlador AuthController funcione correctamente cuando el ususario envía credenciales válidas al endpoint

@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LoginUseCase loginUseCase; // Crea un objeto simulado del caso de uso

    @MockBean
    private AuthRestMapper mapper;

    @Test //Define un caso de prueba, con credenciales válidas se debe de retornar un token
    void login_WithValidCredentials_ShouldReturnToken() throws Exception {

    AuthRequest request = new AuthRequest(); // La solicitud http que enviará el usuario con sus credenciales
    AuthCredentials credentials = new AuthCredentials();

    TokenResponse tokenResponse = new TokenResponse();
    tokenResponse.setToken("jwt-token");

    TokenResponseDto dto = org.mockito.Mockito.mock(TokenResponseDto.class);

// Cuando el mapper reciba cualquier AuthRequest, devolvera el objeto
    when(mapper.toDomain(any(AuthRequest.class))).thenReturn(credentials);
    when(loginUseCase.login(credentials)).thenReturn(tokenResponse);
    when(mapper.toResponse(tokenResponse)).thenReturn(dto);

    }
}