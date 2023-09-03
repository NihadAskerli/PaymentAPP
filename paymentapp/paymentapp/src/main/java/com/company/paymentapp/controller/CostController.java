package com.company.paymentapp.controller;

import com.company.paymentapp.models.base.BaseResponse;
import com.company.paymentapp.models.payload.cost.CostSave;
import com.company.paymentapp.models.payload.course.CourseSave;
import com.company.paymentapp.service.cost.CostBusinessServiceImpl;
import com.company.paymentapp.service.cost.CostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/cost")
@RequiredArgsConstructor
public class CostController {
    private final CostService costService;

    @PostMapping("/save")
    public BaseResponse<Void> savePayment(@RequestParam("value") String costSave, @RequestParam("file") MultipartFile multipartFile) {
        System.out.println(LocalDate.now());
        costService.costSave(costSave, multipartFile);
        return BaseResponse.success();
    }
}
