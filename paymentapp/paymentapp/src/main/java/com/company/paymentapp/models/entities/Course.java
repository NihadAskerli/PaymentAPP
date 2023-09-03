package com.company.paymentapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "courses")
@Entity
public class Course {
    @Id
    @SequenceGenerator(name = "app_seq", allocationSize = 1)
    @GeneratedValue(generator = "app_seq")
    Long id;
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
