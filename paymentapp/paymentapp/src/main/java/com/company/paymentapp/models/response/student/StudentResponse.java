package com.company.paymentapp.models.response.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StudentResponse {

    String name;
    String surname;

    String email;

    String phoneNumber;
}