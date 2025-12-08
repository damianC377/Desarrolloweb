package com.skatingSchool.v1.adapter.in.validator;

import java.time.LocalDate;


import org.springframework.stereotype.Component;

@Component
public class EventValidator extends SimpleValidator {

    public String eventTitleValidator(String eventTitle) throws Exception {
        return stringValidator("Titulo del evento: ", eventTitle);
    }

    public LocalDate eventDateValidator(String eventDate) throws Exception {
        return dateValidator("Fecha del evento: ", eventDate);
    }

    public String eventDescriptionValidator(String eventDescription) throws Exception {
        return stringValidator("Descripcion del evento: ", eventDescription);
    }
    
    public String eventLocationValidator(String eventLocation) throws Exception {
        return stringValidator("Lugar del evento: ", eventLocation);
    }

    public Long eventUserIdValidator(String eventUserId)  throws Exception {
        return longValidator("ID del usuario que crea el evento: ", eventUserId);
    }
}
