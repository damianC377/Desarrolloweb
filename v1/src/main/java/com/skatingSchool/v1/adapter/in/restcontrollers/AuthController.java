package com.skatingSchool.v1.adapter.in.restcontrollers;

import com.skatingSchool.v1.adapter.rest.mapper.AuthRestMapper;
import com.skatingSchool.v1.adapter.rest.request.AuthRequest;
import com.skatingSchool.v1.adapter.rest.response.TokenResponseDto;
import com.skatingSchool.v1.application.usecases.LoginUseCase;
import com.skatingSchool.v1.domain.model.auth.AuthCredentials;
import com.skatingSchool.v1.domain.model.auth.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private LoginUseCase loginUseCase;

    @Autowired
    private AuthRestMapper mapper;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody AuthRequest request) throws Exception {
        AuthCredentials credentials = mapper.toDomain(request);
        TokenResponse token = loginUseCase.login(credentials);
        return ResponseEntity.ok(mapper.toResponse(token));
    }
}
