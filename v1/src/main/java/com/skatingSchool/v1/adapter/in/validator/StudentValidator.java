package com.skatingSchool.v1.adapter.in.validator;

import org.springframework.stereotype.Component;

@Component
public class StudentValidator extends SimpleValidator {

    public long userIdValidator(String value) throws Exception {
        return longValidator("el ID del usuario asociado al estudiante", value);
    }

    public boolean activeValidator(String value) throws Exception {
        stringValidator("el estado activo del estudiante", value);

        if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) {
            throw new Exception("el estado activo debe ser 'true' o 'false'");
        }

        return Boolean.parseBoolean(value);
    }
}
