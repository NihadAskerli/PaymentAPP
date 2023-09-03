package com.company.paymentapp.service.cost;

import com.company.paymentapp.exception.BaseException;
import com.company.paymentapp.models.entities.Cost;
import com.company.paymentapp.models.payload.cost.CostSave;
import com.company.paymentapp.service.photo.PhotoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CostBusinessServiceImpl implements CostService{
    private final ObjectMapper objectMapper;
    private final CostServiceImpl costService;
    private final PhotoServiceImpl photoService;
    @Override
    public void costSave(String value, MultipartFile multipartFile) {
        CostSave costSave= null;
        try {
            costSave = objectMapper.readValue(value, CostSave.class);
        } catch (JsonProcessingException e) {
            throw BaseException.unexpected();
        }
        Cost cost=objectMapper.convertValue(costSave,Cost.class);
        String url=photoService.getUrls(multipartFile);
        cost.setPhotoURL(url);
        costService.saveCost(cost);
    }
}
