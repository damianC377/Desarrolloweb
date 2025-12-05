package com.skatingSchool.v1.infraestructure.persistence.repository;

import com.skatingSchool.v1.infraestructure.persistence.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    List<PaymentEntity> findByStudent_StudentId(Long studentId);

    List<PaymentEntity> findByPaymentDate(LocalDate date);

    @Query("SELECT p FROM PaymentEntity p " +
           "WHERE p.student.studentId = :studentId " +
           "ORDER BY p.paymentDate DESC")
    List<PaymentEntity> findLatestPaymentByStudent(Long studentId);
}
