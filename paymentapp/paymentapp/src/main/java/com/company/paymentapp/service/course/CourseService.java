package com.company.paymentapp.service.course;

import com.company.paymentapp.models.payload.course.CourseSave;
import com.company.paymentapp.models.response.course.CourseResponse;

public interface CourseService {
    void saveCourse(CourseSave courseSave);



    CourseResponse findCourseByName(String courseName);
}
