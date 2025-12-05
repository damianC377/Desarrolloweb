package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.Payment;
import com.skatingSchool.v1.infraestructure.persistence.entities.PaymentEntity;

public class PaymentMapper {

    public static PaymentEntity toEntity(Payment payment) {
        if (payment == null) {
            return null;
        }

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentId(payment.getPaymentId());
        paymentEntity.setStudentId(payment.getStudentId());
        paymentEntity.setPaymentDate(payment.getPaymentDate());
        paymentEntity.setAmount(payment.getAmount());
        paymentEntity.setPaymentMethod(payment.getPaymentMethod());

        return paymentEntity;
    }

    public static Payment toDomain(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }

        Payment payment = new Payment();
        payment.setPaymentId(entity.getPaymentId());
        payment.setStudent(entity.getStudentId());
        payment.setPaymentDate(entity.getPaymentDate());
        payment.setAmount(entity.getAmount());
        payment.setPaymentMethod(entity.getPaymentMethod());

        return payment;
    }
}
