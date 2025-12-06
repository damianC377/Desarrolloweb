package com.skatingSchool.v1.domain.model.auth;

public class TokenResponse {
    private String token;
    private Long id; // 👈 nuevo campo

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
