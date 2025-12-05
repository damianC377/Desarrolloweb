package com.skatingSchool.v1.adapter.in.validator;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Component
public class PaymentValidator extends SimpleValidator {

    public long paymentIdValidator(String value) throws Exception {
        return longValidator("el ID del pago", value);
    }

    public long studentIdValidator(String value) throws Exception {
        return longValidator("el ID del estudiante asociado al pago", value);
    }

    public LocalDate paymentDateValidator(String value) throws Exception {
        stringValidator("la fecha del pago", value);

        try {
            return LocalDate.parse(value);
        } catch (DateTimeParseException e) {
            throw new Exception("la fecha del pago debe tener el formato YYYY-MM-DD");
        }
    }

    public double amountValidator(String value) throws Exception {
        double amount = doubleValidator("el monto del pago", value);

        if (amount <= 0) {
            throw new Exception("el monto del pago debe ser mayor que 0");
        }

        return amount;
    }

    public String paymentMethodValidator(String value) throws Exception {
        return stringValidator("el método de pago", value);
    }
}
