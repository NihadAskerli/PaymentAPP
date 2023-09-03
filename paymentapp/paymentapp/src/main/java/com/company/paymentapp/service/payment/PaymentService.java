package com.company.paymentapp.service.payment;

import org.springframework.web.multipart.MultipartFile;

public interface PaymentService {
    void savePayment(String value, MultipartFile multipartFile);
}
