package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.User;

public interface FindUserPort {

    User findById(Long userId);

    User findUserByEmail(String email);

    User findUserByDocument(Long document);

    User findUserByUsername(String username);


}
