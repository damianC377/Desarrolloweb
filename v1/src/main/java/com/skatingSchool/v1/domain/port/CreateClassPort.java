package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Class;

public interface CreateClassPort {

    void save(Class skatingClass);
}
