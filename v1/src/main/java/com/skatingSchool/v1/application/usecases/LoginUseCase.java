package com.skatingSchool.v1.application.usecases;

import com.skatingSchool.v1.domain.service.AuthenticationService;
import com.skatingSchool.v1.domain.model.auth.AuthCredentials;
import com.skatingSchool.v1.domain.model.auth.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUseCase {

    @Autowired
    private AuthenticationService authenticationService;

    public TokenResponse login(AuthCredentials credentials) throws Exception {
        return authenticationService.authenticate(credentials);
    }
}
