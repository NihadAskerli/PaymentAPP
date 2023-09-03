package com.company.paymentapp.service.student;

import com.company.paymentapp.models.dto.StudentDto;
import com.company.paymentapp.models.entities.Course;
import com.company.paymentapp.models.entities.Student;
import com.company.paymentapp.models.payload.student.AddStudent;
import com.company.paymentapp.models.payload.student.SaveStudent;
import com.company.paymentapp.models.response.student.StudentResponse;
import com.company.paymentapp.service.course.CourseServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
@RequiredArgsConstructor
public class StudentBusinessServiceImpl implements StudentService {
    private final ObjectMapper objectMapper;
    private final StudentServiceImpl studentService;
    private final CourseServiceImpl courseService;

    @Override
    public void studentSave(SaveStudent saveStudent) {
        Student student = objectMapper.convertValue(saveStudent, Student.class);
        System.out.println(student);
        studentService.studentSave(student);
    }

    @Override
    public LinkedList<StudentResponse> getAllStudent(Integer size) {
        LinkedList<StudentResponse> studentResponses = new LinkedList<>();
       studentService.getAllStudent(size).forEach(student -> {
           StudentDto studentDto=convertStudentDto(student);
            StudentResponse studentResponse = objectMapper.convertValue(studentDto, StudentResponse.class);
            studentResponses.add(studentResponse);
        });
        return studentResponses;
    }

    @Override
    public StudentResponse getStudentByPhone(String phone) {
        Student student = studentService.getStudentByPhone(phone);
        StudentDto studentDto = convertStudentDto(student);
        return objectMapper.convertValue(studentDto, StudentResponse.class);
    }

    @Override
    public void addStudent(AddStudent addStudent) {
        Student student = studentService.getStudentByPhone(addStudent.getStudentPhoneNumber());
        Course course = courseService.findCourseByName(addStudent.getCourseName());
        student.getCourses().add(course);
        studentService.studentSave(student);
    }

    private StudentDto convertStudentDto(Student student) {

        return StudentDto.builder().name(student.getName()).surname(student.getSurname())
                .email(student.getEmail()).phoneNumber(student.getPhoneNumber()).build();
    }
}
