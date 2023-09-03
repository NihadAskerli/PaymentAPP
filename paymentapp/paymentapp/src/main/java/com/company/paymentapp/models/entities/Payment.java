package com.company.paymentapp.models.entities;

import jakarta.persistence.*;
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
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @SequenceGenerator(name = "app_seq", allocationSize = 1)
    @GeneratedValue(generator = "app_seq")
    Long id;
    Double pay;
    Integer courseMonth;
    LocalDate checkDate;
    String cardOwn;
    String checkURl;
    String courseName;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;

}
