package com.company.paymentapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "students")
@Builder
public class Student {
    @Id
    @SequenceGenerator(name = "app_seq", allocationSize = 1)
    @GeneratedValue(generator = "app_seq")
    Long id;

    String name;
    String surname;
    @Column(unique = true)
    String email;
    @Column(unique = true)
    String phoneNumber;
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    List<Course> courses;
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<Payment> payments;


}
