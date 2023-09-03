package com.company.paymentapp.service.student;

import com.company.paymentapp.models.payload.student.AddStudent;
import com.company.paymentapp.models.payload.student.SaveStudent;
import com.company.paymentapp.models.response.student.StudentResponse;

import java.util.LinkedList;

public interface StudentService {
    void studentSave(SaveStudent saveStudent);

    LinkedList<StudentResponse> getAllStudent(Integer size);
    void addStudent(AddStudent addStudent);

    StudentResponse getStudentByPhone(String phone);
}
