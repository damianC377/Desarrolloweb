package com.skatingSchool.v1.adapter.in.validator;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Component
public class AttendanceValidator extends SimpleValidator {

    public long classSessionIdValidator(String value) throws Exception {
        return longValidator("el ID de la clase asociada a la asistencia", value);
    }

    public long studentIdValidator(String value) throws Exception {
        return longValidator("el ID del estudiante asociado a la asistencia", value);
    }

    public LocalDate attendanceDateValidator(String value) throws Exception {
        stringValidator("la fecha de asistencia", value);

        try {
            return LocalDate.parse(value);
        } catch (DateTimeParseException e) {
            throw new Exception("la fecha de asistencia debe tener el formato YYYY-MM-DD");
        }
    }

    public boolean presentValidator(String value) throws Exception {
        stringValidator("el estado de asistencia (presente)", value);

        if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) {
            throw new Exception("el campo 'present' debe ser 'true' o 'false'");
        }

        return Boolean.parseBoolean(value);
    }
}
