package com.skatingSchool.v1.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.validator.PaymentValidator;
import com.skatingSchool.v1.domain.model.Payment;

@Component
public class Paymentbuilder {

    @Autowired
    private PaymentValidator validator;

    public Paymentbuilder() {
        this.validator = new PaymentValidator();
    }

    public Payment build(String studentId, String paymentDate, String amount, String paymentMethod) throws Exception {

        Payment payment = new Payment();

        payment.setStudentId(validator.studentIdValidator(studentId));
        payment.setPaymentDate(validator.paymentDateValidator(paymentDate));
        payment.setAmount(validator.amountValidator(amount));
        payment.setPaymentMethod(validator.paymentMethodValidator(paymentMethod));

        return payment;
    }
}
