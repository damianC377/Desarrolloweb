package com.skatingSchool.v1.adapter.rest.response;

public class TokenResponseDto {
    private String token;
    private Long id;

    public TokenResponseDto(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }
}
