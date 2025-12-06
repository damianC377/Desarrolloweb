package com.skatingSchool.v1.domain.service;

import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Payment;
import com.skatingSchool.v1.domain.port.CreatePaymentPort;
import com.skatingSchool.v1.domain.port.FindPaymentPort;

@Service
public class CreatePaymentService {

    private final CreatePaymentPort createPaymentPort;
    private final FindPaymentPort findPaymentPort;

    public CreatePaymentService(CreatePaymentPort createPaymentPort, FindPaymentPort findPaymentPort) {
        this.createPaymentPort = createPaymentPort;
        this.findPaymentPort = findPaymentPort;
    }

    public void createPayment(Payment payment) throws Exception {
        if (payment.getPaymentId() != null &&
                findPaymentPort.findById(payment.getPaymentId()) != null) {
            throw new Exception("El pago con ID " + payment.getPaymentId() + " ya existe.");
        }

        if (payment.getStudentId() <= 0) {
            throw new Exception("El pago debe estar asociado a un estudiante válido.");
        }

        if (payment.getAmount() == null || payment.getAmount() <= 0) {
            throw new Exception("El monto del pago debe ser mayor que 0.");
        }

        if (payment.getPaymentMethod() == null || payment.getPaymentMethod().isBlank()) {
            throw new Exception("El método de pago no puede estar vacío.");
        }

        if (payment.getPaymentDate() == null) {
            throw new Exception("La fecha del pago no puede estar vacía.");
        }

        Payment lastPayment = findPaymentPort.findLatestPaymentByStudent(payment.getStudentId());

        if (lastPayment != null) {
            boolean sameYear = lastPayment.getPaymentDate().getYear() == payment.getPaymentDate().getYear();
            boolean sameMonth = lastPayment.getPaymentDate().getMonthValue() == payment.getPaymentDate().getMonthValue();

            if (sameYear && sameMonth) {
                throw new Exception(
                    "El estudiante ya realizó un pago en " +
                    payment.getPaymentDate().getMonth() + " del " +
                    payment.getPaymentDate().getYear() + "."
                );
            }
        }

        // Guardar el pago
        createPaymentPort.save(payment);
    }
}
