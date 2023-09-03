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
@Table(name = "costs")
@Entity
public class Cost {
    @Id
    @SequenceGenerator(name = "app_seq", allocationSize = 1)
    @GeneratedValue(generator = "app_seq")
            @Column(name = "id")
    Long id;
    @Column(name = "price")
    Double price;
    String costName;
    LocalDate localDate;
    String cardOwn;
    String photoURL;
}
