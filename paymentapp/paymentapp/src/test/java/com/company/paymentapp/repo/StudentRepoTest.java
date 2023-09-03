package com.company.paymentapp.repo;

import com.company.paymentapp.models.entities.Course;
import com.company.paymentapp.models.entities.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;
    @Test
    public void findStudentByNumberTest() {
        Student student = Student.builder().email("test@gmail.com").name("test").phoneNumber("994").surname("test").build();
        studentRepo.save(student);
        Student findCourse = studentRepo.findByPhoneNumber("994").get();
        Assertions.assertThat(findCourse).isNotNull();
        Assertions.assertThat(findCourse.getId()).isGreaterThan(0);
    }
}
