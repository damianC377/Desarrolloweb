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

    @Override
    public void save(Payment payment) {
        PaymentEntity entity = PaymentMapper.toEntity(payment);
        paymentRepository.save(entity);
    }

    @Override
    public Payment findById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .map(PaymentMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Payment> findByStudentId(Long studentId) {
        return paymentRepository.findByStudentId(studentId)
                .stream()
                .map(PaymentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Payment> findByDate(LocalDate date) {
        return paymentRepository.findByPaymentDate(date)
                .stream()
                .map(PaymentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Payment findLatestPaymentByStudent(Long studentId) {
        PaymentEntity entity = paymentRepository.findLatestPaymentByStudent(studentId);
        return PaymentMapper.toDomain(entity);
    }
}
