package com.company.paymentapp.repo;

import com.company.paymentapp.models.entities.Course;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CourseRepoTest {
    @Autowired
    private CourseRepo courseRepo;
    @Test
    public void findCourseByNameTest() {
        Course course = Course.builder().courseName("Java").build();
        courseRepo.save(course);
        Course findCourse = courseRepo.findByCourseName("Java").get();
        Assertions.assertThat(findCourse).isNotNull();
        Assertions.assertThat(findCourse.getId()).isGreaterThan(0);
    }
}
