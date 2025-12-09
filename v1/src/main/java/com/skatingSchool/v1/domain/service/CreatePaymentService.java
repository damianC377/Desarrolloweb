package com.skatingSchool.v1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Payment;
import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.CreatePaymentPort;
import com.skatingSchool.v1.domain.port.FindPaymentPort;
import com.skatingSchool.v1.domain.port.FindStudentPort;
import com.skatingSchool.v1.domain.port.CreateStudentPort;

@Service
public class CreatePaymentService {

    @Autowired
    private CreatePaymentPort createPaymentPort;

    @Autowired
    private FindPaymentPort findPaymentPort;

    @Autowired
    private FindStudentPort findStudentPort;

    @Autowired
    private CreateStudentPort createStudentPort;

    public void createPayment(Payment payment) throws Exception {
        // Validaciones existentes
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

        // Verificar pagos duplicados del mes
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

        // 🔥 NUEVO: Activar al estudiante si es su primer pago
        Student student = findStudentPort.findById(payment.getStudentId());
        
        if (student == null) {
            throw new Exception("Estudiante con ID " + payment.getStudentId() + " no encontrado.");
        }

        // Si el estudiante está inactivo, activarlo
        if (!student.getActive()) {
            student.setActive(true);
            createStudentPort.save(student); // Actualizar el estado
            System.out.println("✅ Estudiante ID " + student.getStudentId() + " activado tras primer pago");
        }

        // Guardar el pago
        createPaymentPort.save(payment);
    }
}