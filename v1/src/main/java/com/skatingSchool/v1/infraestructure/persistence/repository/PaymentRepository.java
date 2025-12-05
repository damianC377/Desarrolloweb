package com.skatingSchool.v1.infraestructure.persistence.repository;

import com.skatingSchool.v1.infraestructure.persistence.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    List<PaymentEntity> findByStudentId(Long studentId);

    List<PaymentEntity> findByPaymentDate(LocalDate date);

    PaymentEntity findTopByStudentIdOrderByPaymentDateDesc(Long studentId);
}
