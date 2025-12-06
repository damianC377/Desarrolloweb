package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.auth.AuthCredentials;
import com.skatingSchool.v1.domain.model.auth.TokenResponse;

public interface AuthenticationPort {

    TokenResponse authenticate(AuthCredentials credentials, String role, Long id);

    boolean validateToken(String token);

    String extractUsername(String token);

    String extractRole(String token);

    Long extractId(String token); // 👈 Cambiar a Long
}

