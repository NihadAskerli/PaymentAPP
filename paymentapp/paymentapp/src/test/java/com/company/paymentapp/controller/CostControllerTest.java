package com.company.paymentapp.controller;

import com.company.paymentapp.service.cost.CostBusinessServiceImpl;
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

@WebMvcTest(CostController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CostBusinessServiceImpl costBusinessService;

    @Test
    public void saveCost() throws Exception {
        String costSave = "{\n" +
                "    \"value\":78,\n" +
                "    \"costName\":\"var\",\n" +
                "    \"localDate\":\"2023-01-01\",\n" +
                "    \"cardOwn\":\"sen\"\n" +
                "}";
        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "image/png", "Test data".getBytes());

        doNothing().when(costBusinessService).costSave(costSave, file);


        mockMvc.perform(multipart("/api/v1/cost/save")
                        .file(file)
                        .param("value", costSave))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.meta.message").value("Successfully"));

        verify(costBusinessService, times(1)).costSave(costSave, file);
    }
}
