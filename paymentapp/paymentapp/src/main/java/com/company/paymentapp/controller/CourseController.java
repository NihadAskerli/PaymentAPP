package com.company.paymentapp.controller;

import com.company.paymentapp.models.base.BaseResponse;
import com.company.paymentapp.models.payload.student.AddStudent;
import com.company.paymentapp.models.payload.course.CourseSave;
import com.company.paymentapp.models.response.course.CourseResponse;
import com.company.paymentapp.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/save")
    public BaseResponse<Void> savePayment(@RequestBody CourseSave courseSave) {
        courseService.saveCourse(courseSave);
        return BaseResponse.success();
    }

    @GetMapping("/search-by-name")
    public BaseResponse<CourseResponse> addStudent(@RequestParam("name") String name) {
        return BaseResponse.success( courseService.findCourseByName(name));
    }
}
