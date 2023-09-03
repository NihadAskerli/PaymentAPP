package com.company.paymentapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Table(name = "courses")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Course {
    @Id
    @SequenceGenerator(name = "app_seq", allocationSize = 1)
    @GeneratedValue(generator = "app_seq")
    @Column(name = "id")
    Long id;
    @Column(unique = true)
    String courseName;
    @ManyToMany(mappedBy = "courses")
    List<Student> studentList;

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                '}';
    }
}
