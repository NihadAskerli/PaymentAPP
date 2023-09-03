package com.company.paymentapp.models.payload.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentSave {
    Double pay;
    Integer month;
    LocalDate checkDate;
    String cardOwn;
    String studentPhoneNumber;
    String courseName;

}
