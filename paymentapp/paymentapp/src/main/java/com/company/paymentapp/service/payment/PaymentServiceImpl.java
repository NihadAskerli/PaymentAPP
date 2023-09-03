package com.company.paymentapp.service.payment;

import com.company.paymentapp.models.entities.Payment;
import com.company.paymentapp.models.entities.Student;
import com.company.paymentapp.models.payload.payment.PaymentSave;
import com.company.paymentapp.repo.PaymentRepo;
import com.company.paymentapp.service.student.StudentService;
import com.company.paymentapp.service.student.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl  {
    private final ObjectMapper objectMapper;
    private final PaymentRepo paymentRepo;
    private final StudentServiceImpl studentService;


    public void savePayment(Payment payment) {

        paymentRepo.save(payment);
    }
}
