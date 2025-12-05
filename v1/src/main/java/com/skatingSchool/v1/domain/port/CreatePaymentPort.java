package com.skatingSchool.v1.domain.port;

import com.skatingSchool.v1.domain.model.Payment;

public interface CreatePaymentPort {

    Payment save(Payment payment);
}
