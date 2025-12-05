package com.skatingSchool.v1.adapter.out.persistence;

import com.skatingSchool.v1.domain.model.Payment;
import com.skatingSchool.v1.domain.port.CreatePaymentPort;
import com.skatingSchool.v1.domain.port.FindPaymentPort;
import com.skatingSchool.v1.infraestructure.persistence.entities.PaymentEntity;
import com.skatingSchool.v1.infraestructure.persistence.mapper.PaymentMapper;
import com.skatingSchool.v1.infraestructure.persistence.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentAdapter implements CreatePaymentPort, FindPaymentPort {

    @Autowired
    private PaymentRepository paymentRepository;

    // =========================================
    //              CREATE PAYMENT
    // =========================================
    @Override
    public void save(Payment payment) {
        PaymentEntity entity = PaymentMapper.toEntity(payment);
        paymentRepository.save(entity);   // no retorna nada
    }

    // =========================================
    //            FIND PAYMENT BY ID
    // =========================================
    @Override
    public Payment findById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .map(PaymentMapper::toDomain)
                .orElse(null);
    }

    // =========================================
    //        FIND PAYMENTS BY STUDENT ID
    // =========================================
    @Override
    public List<Payment> findByStudentId(Long studentId) {
        return paymentRepository.findByStudent_StudentId(studentId)
                .stream()
                .map(PaymentMapper::toDomain)
                .collect(Collectors.toList());
    }

    // =========================================
    //            FIND PAYMENTS BY DATE
    // =========================================
    @Override
    public List<Payment> findByDate(LocalDate date) {
        return paymentRepository.findByPaymentDate(date)
                .stream()
                .map(PaymentMapper::toDomain)
                .collect(Collectors.toList());
    }

    // =========================================
    //     FIND LATEST PAYMENT BY STUDENT
    // =========================================
    @Override
    public Payment findLatestPaymentByStudent(Long studentId) {
        List<PaymentEntity> list = paymentRepository.findLatestPaymentByStudent(studentId);

        if (list.isEmpty()) {
            return null;
        }

        return PaymentMapper.toDomain(list.get(0)); // más reciente
    }
}
