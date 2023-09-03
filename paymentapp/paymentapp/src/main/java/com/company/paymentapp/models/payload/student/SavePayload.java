package com.company.paymentapp.models.payload.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePayload {
    private String name;
    private String surname;
    private  String email;
    private String phoneNumber;
}
