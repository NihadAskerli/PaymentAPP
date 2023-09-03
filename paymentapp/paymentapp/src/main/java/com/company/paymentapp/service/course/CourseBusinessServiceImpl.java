package com.company.paymentapp.service.course;

import com.company.paymentapp.models.dto.CourseDto;
import com.company.paymentapp.models.entities.Course;
import com.company.paymentapp.models.payload.course.CourseSave;
import com.company.paymentapp.models.response.course.CourseResponse;
import com.company.paymentapp.service.student.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseBusinessServiceImpl implements CourseService {
    private final ObjectMapper objectMapper;
    private final CourseServiceImpl courseService;
    private final StudentServiceImpl studentService;

    @Override
    public void saveCourse(CourseSave courseSave) {
        Course course = objectMapper.convertValue(courseSave, Course.class);
        courseService.saveCourse(course);
    }



    @Override
    public CourseResponse findCourseByName(String courseName) {
        Course course=courseService.findCourseByName(courseName);
        System.out.println(course);
        CourseDto courseDto=CourseDto.builder().courseName(course.getCourseName()).build();
        CourseResponse courseResponse=objectMapper.convertValue(courseDto, CourseResponse.class);
        return courseResponse;
    }
}
