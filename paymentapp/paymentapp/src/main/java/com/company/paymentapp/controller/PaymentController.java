package com.company.paymentapp.controller;

import com.company.paymentapp.models.base.BaseResponse;
import com.company.paymentapp.models.payload.payment.PaymentSave;
import com.company.paymentapp.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping("/pay")
    public BaseResponse<Void> savePayment(@RequestParam("value") String paymentSave,@RequestParam("file") MultipartFile file){
        paymentService.savePayment(paymentSave,file);
        return BaseResponse.success();
    }
}
