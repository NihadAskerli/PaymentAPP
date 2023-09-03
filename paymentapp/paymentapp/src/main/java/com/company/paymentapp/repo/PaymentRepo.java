package com.company.paymentapp.repo;

import com.company.paymentapp.models.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
