package com.company.paymentapp.controller;

import com.company.paymentapp.service.payment.PaymentBusinessServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PaymentController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private PaymentBusinessServiceImpl paymentBusinessService;
    @Test
    public void savePayment() throws Exception {
      String paymentSave="{\"pay\":67,\"month\":\"6\",\"checkDate\":\"2023-01-01\",\"cardOwn\":\"sen\",\"studentPhoneNumber\":\"0516878738\",\"courseName\":\"Java\"}";
        MockMultipartFile file = new MockMultipartFile("file", "test.txt","image/png", "Test data".getBytes());

        doNothing().when(paymentBusinessService).savePayment(paymentSave, file);



        mockMvc.perform(multipart("/api/v1/payment/pay")
                        .file(file)
                        .param("value", paymentSave))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.meta.message").value("Successfully"));

        verify(paymentBusinessService, times(1)).savePayment(paymentSave, file);
    }
}
