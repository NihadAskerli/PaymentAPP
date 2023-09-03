package com.company.paymentapp.controller;

import com.company.paymentapp.models.base.BaseResponse;
import com.company.paymentapp.models.payload.student.AddStudent;
import com.company.paymentapp.models.payload.student.SaveStudent;
import com.company.paymentapp.models.response.student.StudentResponse;
import com.company.paymentapp.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/save")
    public BaseResponse<Void> saveStudent(@RequestBody SaveStudent saveStudent) {
        studentService.studentSave(saveStudent);
        return BaseResponse.success();
    }

    @GetMapping("/all")
    public BaseResponse<List> getAllStudent(@RequestParam("size") Integer size) {
        return BaseResponse.success(studentService.getAllStudent(size));
    }
    @GetMapping("/search-by-phone")
    public BaseResponse<StudentResponse> getAllStudent(@RequestParam("phone") String phone) {
        return BaseResponse.success(studentService.getStudentByPhone(phone));
    }
    @PostMapping("/add-course")
    public BaseResponse<Void> addStudent(@RequestBody AddStudent addStudent) {
        studentService.addStudent(addStudent);
        return BaseResponse.success();
    }
}

