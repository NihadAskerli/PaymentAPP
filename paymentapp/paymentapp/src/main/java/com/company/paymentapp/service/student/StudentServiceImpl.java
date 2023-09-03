package com.company.paymentapp.service.student;

import com.company.paymentapp.exception.BaseException;
import com.company.paymentapp.models.entities.Student;
import com.company.paymentapp.repo.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.company.paymentapp.models.enums.response.ErrorResponseMessages.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl {
    private final StudentRepo studentRepo;
    private final ObjectMapper objectMapper;


    public void studentSave(Student student) {
        studentRepo.save(student);
    }


    public List<Student> getAllStudent(Integer size) {

        return studentRepo.findAll(Pageable.ofSize(size)).toList();
    }


    public Student getStudentByPhone(String phone) {
       Student student=studentRepo.findByPhoneNumber(phone).orElseThrow(
               () -> BaseException.notFound(Student.class.getSimpleName(),"phoneNumber",phone));
        return student;
    }
}
