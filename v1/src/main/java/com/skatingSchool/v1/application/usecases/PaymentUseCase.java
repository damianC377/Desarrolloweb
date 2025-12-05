package com.skatingSchool.v1.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Payment;
import com.skatingSchool.v1.domain.service.CreatePaymentService;

@Service
public class PaymentUseCase {

    @Autowired
    private CreatePaymentService createPaymentService;

    public void createPayment(Payment payment) throws Exception {
        createPaymentService.createPayment(payment);
    }
}
