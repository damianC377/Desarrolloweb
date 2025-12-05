package com.skatingSchool.v1.adapter.in.validator;

import org.springframework.stereotype.Component;

@Component
public class InstructorValidator extends SimpleValidator {

    public long userIdValidator(String value) throws Exception {
        return longValidator("el ID del usuario asociado al instructor", value);
    }

    public String experienceValidator(String value) throws Exception {
        return stringValidator("la experiencia del instructor", value);
    }
}
