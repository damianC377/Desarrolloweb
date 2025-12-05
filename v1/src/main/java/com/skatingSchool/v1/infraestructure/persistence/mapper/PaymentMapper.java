package com.skatingSchool.v1.infraestructure.persistence.mapper;

import com.skatingSchool.v1.domain.model.Payment;
import com.skatingSchool.v1.infraestructure.persistence.entities.PaymentEntity;

public class PaymentMapper {

    public static PaymentEntity toEntity(Payment payment) {
        if (payment == null) {
            return null;
        }

        PaymentEntity paymententity = new PaymentEntity();
        paymententity.setPaymentId(payment.getPaymentId());
        paymententity.setStudent(StudentMapper.toEntity(payment.getStudent()));
        paymententity.setPaymentDate(payment.getPaymentDate());
        paymententity.setAmount(payment.getAmount());
        paymententity.setPaymentMethod(payment.getPaymentMethod());

        return paymententity;
    }

    public static Payment toDomain(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }

        Payment payment = new Payment();
        payment.setPaymentId(entity.getPaymentId());
        payment.setStudent(StudentMapper.toDomain(entity.getStudent()));
        payment.setPaymentDate(entity.getPaymentDate());
        payment.setAmount(entity.getAmount());
        payment.setPaymentMethod(entity.getPaymentMethod());

        return payment;
    }
}
