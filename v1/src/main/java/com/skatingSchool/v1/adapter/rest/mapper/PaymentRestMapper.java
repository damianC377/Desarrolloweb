package com.skatingSchool.v1.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skatingSchool.v1.adapter.in.builder.Paymentbuilder;
import com.skatingSchool.v1.adapter.rest.request.PaymentRequest;
import com.skatingSchool.v1.adapter.rest.response.PaymentResponse;
import com.skatingSchool.v1.domain.model.Payment;

@Component
public class PaymentRestMapper {

    @Autowired
    private Paymentbuilder paymentbuilder;

    public Payment toDomain(PaymentRequest req) throws Exception {
        if (req == null) {
            return null;
        }

        return paymentbuilder.build(
            req.getStudentId(),
            req.getPaymentDate(),
            req.getAmount(),
            req.getPaymentMethod()
        );
    }

    public PaymentResponse toResponse(Payment payment) {
        if (payment == null) {
            return null;
        }

        PaymentResponse resp = new PaymentResponse();
        resp.setPaymentId(payment.getPaymentId());
        resp.setStudentId(payment.getStudentId());
        resp.setPaymentDate(payment.getPaymentDate());
        resp.setAmount(payment.getAmount());
        resp.setPaymentMethod(payment.getPaymentMethod());

        return resp;
    }
}
