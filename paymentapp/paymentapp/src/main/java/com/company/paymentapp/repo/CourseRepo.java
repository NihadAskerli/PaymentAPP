package com.company.paymentapp.repo;

import com.company.paymentapp.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course,Long> {
Optional<Course>findByCourseName(String name);
}
