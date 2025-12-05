package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Payment;

import java.time.LocalDate;
import java.util.List;

public interface FindPaymentPort {

    Payment findById(Long paymentId);

    List<Payment> findByStudentId(Long studentId);

    List<Payment> findByDate(LocalDate date);

    Payment findLatestPaymentByStudent(Long studentId);
}
