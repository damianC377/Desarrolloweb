package com.skatingSchool.v1.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Payment;
import com.skatingSchool.v1.domain.service.CreatePaymentService;
import com.skatingSchool.v1.domain.service.FindPaymentService; // 🔥 NUEVO

import java.util.List;

@Service
public class PaymentUseCase {

    @Autowired
    private CreatePaymentService createPaymentService;

    @Autowired
    private FindPaymentService findPaymentService; // 🔥 NUEVO

    public void createPayment(Payment payment) throws Exception {
        createPaymentService.createPayment(payment);
    }

    // 🔥 NUEVO MÉTODO
    public List<Payment> findAllPayments() throws Exception {
        return findPaymentService.findAll();
    }
}