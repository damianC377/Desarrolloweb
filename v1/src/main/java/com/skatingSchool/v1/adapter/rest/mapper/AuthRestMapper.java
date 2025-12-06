package com.skatingSchool.v1.adapter.rest.mapper;

import com.skatingSchool.v1.adapter.rest.request.AuthRequest;
import com.skatingSchool.v1.adapter.rest.response.TokenResponseDto;
import com.skatingSchool.v1.domain.model.auth.AuthCredentials;
import com.skatingSchool.v1.domain.model.auth.TokenResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthRestMapper {

    public AuthCredentials toDomain(AuthRequest req) {
        AuthCredentials c = new AuthCredentials();
        c.setUsername(req.getUsername());
        c.setPassword(req.getPassword());
        return c;
    }

    public TokenResponseDto toResponse(TokenResponse t) {
        return new TokenResponseDto(t.getToken(), t.getId()); // 👈 ahora también id
    }
}
