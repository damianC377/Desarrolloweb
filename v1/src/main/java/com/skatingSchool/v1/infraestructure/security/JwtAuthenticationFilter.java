package com.skatingSchool.v1.infraestructure.security;

import com.skatingSchool.v1.domain.port.AuthenticationPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private AuthenticationPort authenticationPort;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token = extractToken(request);

        if (token != null) {
            processToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }

        return null;
    }

    private void processToken(String token) {

        if (authenticationPort.validateToken(token)) {

            String username = authenticationPort.extractUsername(token);
            String role = authenticationPort.extractRole(token);
            Long userId = authenticationPort.extractId(token);

            if (role == null || role.trim().isEmpty()) {
                return; // No role -> no authentication
            }

            String normalized = role.trim().toUpperCase();

            if (!normalized.startsWith("ROLE_")) {
                normalized = "ROLE_" + normalized;
            }

            ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(normalized));

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(
                            username, 
                            null, 
                            authorities
                    );

            auth.setDetails(userId);

            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }
}
