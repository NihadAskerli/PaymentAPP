package com.company.paymentapp.models.payload.student;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveStudent {
    private String name;
    private String surname;
    private  String email;
    private String phoneNumber;
}
