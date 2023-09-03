package com.company.paymentapp.service.course;

import com.company.paymentapp.exception.BaseException;
import com.company.paymentapp.models.entities.Course;
import com.company.paymentapp.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl {
    private final CourseRepo courseRepo;
    public void saveCourse(Course course){
        courseRepo.save(course);
    }
    public Course findCourseByName(String courseName){
        return courseRepo.findByCourseName(courseName)
                .orElseThrow(() -> BaseException.notFound(Course.class.getSimpleName(),"courseName",courseName));
    }
}
