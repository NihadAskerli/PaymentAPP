package com.company.paymentapp.service.student;

import com.company.paymentapp.models.payload.student.AddStudent;
import com.company.paymentapp.models.payload.student.SavePayload;
import com.company.paymentapp.models.response.student.StudentResponse;

import java.util.LinkedList;

public interface StudentService {
    void studentSave(SavePayload savePayload);

    LinkedList<StudentResponse> getAllStudent(Integer size);
    void addStudent(AddStudent addStudent);

    StudentResponse getStudentByPhone(String phone);
}
