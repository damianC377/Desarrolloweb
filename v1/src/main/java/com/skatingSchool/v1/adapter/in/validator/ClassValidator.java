package com.skatingSchool.v1.adapter.in.validator;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClassValidator extends SimpleValidator {

    public String classNameValidator(String value) throws Exception {
        return stringValidator("el nombre de la clase", value);
    }

    public String levelValidator(String value) throws Exception {
        return stringValidator("el nivel de la clase", value);
    }

    public LocalDateTime scheduleValidator(String value) throws Exception {
        stringValidator("el horario (schedule) de la clase", value);
        try {
            return LocalDateTime.parse(value);
        } catch (DateTimeParseException e) {
            throw new Exception("el horario debe tener el formato ISO-8601 (ej: 2025-12-04T15:30:00)");
        }
    }

    public long instructorIdValidator(String value) throws Exception {
        return longValidator("el ID del instructor asociado", value);
    }

    /**
     * Espera una cadena con IDs separados por comas, por ejemplo: "1,2,3"
     * Devuelve una lista de Long con los IDs validados.
     */
    public List<Long> studentsIdsValidator(String value) throws Exception {
        stringValidator("la lista de IDs de estudiantes", value);

        String[] parts = value.split(",");
        List<Long> ids = new ArrayList<>();

        for (String part : parts) {
            String trimmed = part.trim();
            if (trimmed.isEmpty()) {
                continue; // ignora entradas vacías entre comas
            }
            // Reutiliza longValidator para aprovechar la validación y mensajes
            long id = longValidator("id del estudiante", trimmed);
            ids.add(id);
        }

        return ids;
    }
}
