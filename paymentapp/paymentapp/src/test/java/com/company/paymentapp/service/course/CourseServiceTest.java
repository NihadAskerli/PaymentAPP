package com.company.paymentapp.service.course;

import com.company.paymentapp.models.entities.Course;
import com.company.paymentapp.models.entities.Student;
import com.company.paymentapp.models.response.course.CourseResponse;
import com.company.paymentapp.models.response.student.StudentResponse;
import com.company.paymentapp.service.student.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
    @Mock
    private CourseBusinessServiceImpl courseBusinessService;
    @Mock
    private  ObjectMapper objectMapper;
    @Mock
    private  CourseServiceImpl courseService;
    @Mock
    private  StudentServiceImpl studentService;
    @Test
    public void getCourseByName() {
        Course course = new Course(null, "test",  null);
        CourseResponse courseResponse=CourseResponse.builder().courseName(course.getCourseName()).build();
        when(courseBusinessService.findCourseByName(course.getCourseName())).thenReturn(courseResponse);
        CourseResponse courseResponse1 = courseBusinessService.findCourseByName(course.getCourseName());
        Assertions.assertThat(courseResponse1).isNotNull();
    }
}
