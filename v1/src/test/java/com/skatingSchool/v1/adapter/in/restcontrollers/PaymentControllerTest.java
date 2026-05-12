package com.skatingSchool.v1.adapter.in.restcontrollers;

import com.skatingSchool.v1.adapter.rest.mapper.PaymentRestMapper;
import com.skatingSchool.v1.adapter.rest.response.PaymentResponse;
import com.skatingSchool.v1.application.usecases.PaymentUseCase;
import com.skatingSchool.v1.domain.model.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentUseCase paymentUseCase;

    @MockBean
    private PaymentRestMapper paymentRestMapper;

    @Test
    void getPaymentsByStudent_ShouldReturn200() throws Exception {

        Payment payment = new Payment();
        PaymentResponse response = new PaymentResponse();

        when(paymentUseCase.getPaymentsByStudentId(1L))
                .thenReturn(List.of(payment));

        when(paymentRestMapper.toResponse(payment))
                .thenReturn(response);

        mockMvc.perform(get("/api/v1/payments/student/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}