package com.skatingSchool.v1.adapter.out.security;

import com.skatingSchool.v1.domain.model.auth.AuthCredentials;
import com.skatingSchool.v1.domain.model.auth.TokenResponse;
import com.skatingSchool.v1.domain.port.AuthenticationPort;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtAdapter implements AuthenticationPort {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION = 3 * 60 * 1000;

    // =========================================================
    //   NUEVO MÉTODO: Autenticación con ID (student o instructor)
    // =========================================================
    @Override
    public TokenResponse authenticate(AuthCredentials credentials, String role, Long id) {

        String token = Jwts.builder()
                .setSubject(credentials.getUsername())
                .claim("role", role)
                .claim("id", id)  // 👈 ID agregado al JWT
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SECRET_KEY)
                .compact();

        TokenResponse response = new TokenResponse();
        response.setToken(token);
        return response;
    }

    // =========================================================
    //   VALIDAR TOKEN
    // =========================================================
    @Override
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // =========================================================
    //   OBTENER USERNAME
    // =========================================================
    @Override
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // =========================================================
    //   OBTENER ROL
    // =========================================================
    @Override
    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // =========================================================
    //   OBTENER EL ID (studentId / instructorId / userId)
    // =========================================================
    @Override
    public Long extractId(String token) {
        Object value = getClaims(token).get("id");
        return value != null ? Long.parseLong(value.toString()) : null;
    }


    // =========================================================
    //   OBTENER CLAIMS
    // =========================================================
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
