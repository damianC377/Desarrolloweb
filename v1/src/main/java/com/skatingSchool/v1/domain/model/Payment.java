package com.skatingSchool.v1.domain.model;

import java.time.LocalDate;

public class Payment {

    private Long paymentId;
    private Student student;
    private LocalDate paymentDate;
    private Double amount;
    private String paymentMethod;

    public Payment() {
    }

    public Payment(Long paymentId, Student student, LocalDate paymentDate,
                   Double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.student = student;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
