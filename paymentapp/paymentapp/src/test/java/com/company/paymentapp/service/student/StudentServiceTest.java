package com.company.paymentapp.service.student;

import com.company.paymentapp.models.entities.Student;
import com.company.paymentapp.models.response.student.StudentResponse;
import com.company.paymentapp.repo.StudentRepo;
import com.company.paymentapp.service.course.CourseServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepo studentRepo;
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private StudentServiceImpl studentService;
    @Mock
    private CourseServiceImpl courseService;
    @InjectMocks
    private StudentBusinessServiceImpl studentBusinessService;


    @Test
    public void getStudentByPhone() {
        Student student = new Student(null, "test", "test@gmail.com", "test", "994", null, null);
        StudentResponse studentResponse=StudentResponse.builder().phoneNumber(student.getPhoneNumber()).email(student.getEmail())
                .name(student.getName()).surname(student.getSurname()).build();
        when(studentService.getStudentByPhone(student.getPhoneNumber())).thenReturn(student);
        when(studentBusinessService.getStudentByPhone(student.getPhoneNumber())).thenReturn(studentResponse);
        StudentResponse studentResponse1 = studentBusinessService.getStudentByPhone(student.getPhoneNumber());
        Assertions.assertThat(studentResponse1).isNotNull();
    }
    @Test
    public void getAllPersonTest() {
        LinkedList<StudentResponse> studentResponses=new LinkedList<>();
        when(studentBusinessService.getAllStudent(20)).thenReturn(studentResponses);
        LinkedList<StudentResponse> studentResponses1 = studentBusinessService.getAllStudent(20);
        Assertions.assertThat(studentResponses1).isNotNull();
    }

}
