package com.company.paymentapp.service.payment;

import com.company.paymentapp.exception.BaseException;
import com.company.paymentapp.models.entities.Payment;
import com.company.paymentapp.models.entities.Student;
import com.company.paymentapp.models.payload.payment.PaymentSave;
import com.company.paymentapp.service.photo.PhotoServiceImpl;
import com.company.paymentapp.service.student.StudentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PaymentBusinessServiceImpl implements PaymentService {
    private final ObjectMapper objectMapper;
    private final PhotoServiceImpl photoService;
    private final PaymentServiceImpl paymentService;
    private final StudentServiceImpl studentService;

    @Override
    public void savePayment(String value, MultipartFile multipartFile) {
        PaymentSave paymentSave= null;
        try {
            paymentSave = objectMapper.readValue(value, PaymentSave.class);
        } catch (JsonProcessingException e) {
            throw BaseException.unexpected();
        }
        Payment payment = objectMapper.convertValue(paymentSave, Payment.class);
        Student student = studentService.getStudentByPhone(paymentSave.getStudentPhoneNumber());
        String url= photoService.getUrls(multipartFile);
        payment.setStudent(student);
        payment.setCheckURl(url);
        paymentService.savePayment(payment);
    }

}
