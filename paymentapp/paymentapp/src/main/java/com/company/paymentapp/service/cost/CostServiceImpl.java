package com.company.paymentapp.service.cost;

import com.company.paymentapp.models.entities.Cost;
import com.company.paymentapp.repo.CostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostServiceImpl {
    private final CostRepo costRepo;
    public void saveCost(Cost cost){
        costRepo.save(cost);
    }
}
