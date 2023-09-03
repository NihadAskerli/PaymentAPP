package com.company.paymentapp.repo;

import com.company.paymentapp.models.entities.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostRepo extends JpaRepository<Cost,Long> {
}
