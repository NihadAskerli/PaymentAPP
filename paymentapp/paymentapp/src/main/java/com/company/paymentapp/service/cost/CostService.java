package com.company.paymentapp.service.cost;

import org.springframework.web.multipart.MultipartFile;

public interface CostService {
    void costSave(String costSave, MultipartFile multipartFile);
}
