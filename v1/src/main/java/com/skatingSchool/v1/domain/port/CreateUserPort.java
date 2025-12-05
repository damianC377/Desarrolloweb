package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.User;

public interface CreateUserPort {

    void save(User user);
}
