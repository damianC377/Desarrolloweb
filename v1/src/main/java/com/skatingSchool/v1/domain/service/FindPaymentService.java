package com.skatingSchool.v1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Payment;
import com.skatingSchool.v1.domain.port.FindPaymentPort;

import java.util.List;

@Service
public class FindPaymentService {

    @Autowired
    private FindPaymentPort findPaymentPort;

    public List<Payment> findAll() throws Exception {
        return findPaymentPort.findByStudentId(null); // Devuelve todos
    }

    public Payment findById(Long paymentId) throws Exception {
        Payment payment = findPaymentPort.findById(paymentId);
        
        if (payment == null) {
            throw new Exception("Pago con ID " + paymentId + " no encontrado.");
        }
        
        return payment;
    }
}