package com.skatingSchool.v1.adapter.in.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skatingSchool.v1.adapter.rest.mapper.PaymentRestMapper;
import com.skatingSchool.v1.adapter.rest.request.PaymentRequest;
import com.skatingSchool.v1.adapter.rest.response.PaymentResponse;
import com.skatingSchool.v1.application.usecases.PaymentUseCase;
import com.skatingSchool.v1.domain.model.Payment;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentUseCase paymentUseCase;

    @Autowired
    private PaymentRestMapper paymentRestMapper;

    @PostMapping("/register")
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest request) throws Exception {

        Payment payment = paymentRestMapper.toDomain(request);

        paymentUseCase.createPayment(payment);

        return new ResponseEntity<>(
                paymentRestMapper.toResponse(payment),
                HttpStatus.CREATED
        );
    }
}
