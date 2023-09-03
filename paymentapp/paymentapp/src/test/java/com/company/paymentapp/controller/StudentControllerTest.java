package com.company.paymentapp.controller;

import com.company.paymentapp.models.payload.student.AddStudent;
import com.company.paymentapp.models.payload.student.SaveStudent;
import com.company.paymentapp.models.response.student.StudentResponse;
import com.company.paymentapp.service.student.StudentBusinessServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.LinkedList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(StudentController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private StudentBusinessServiceImpl studentBusinessService;
    private SaveStudent saveStudent;
    private StudentResponse studentResponse;

    private AddStudent addStudent;
    @BeforeEach
    public void init() {
        saveStudent = SaveStudent.builder().name("test").email("test").surname("test").phoneNumber("test").build();
        addStudent = AddStudent.builder().studentPhoneNumber("test").courseName("test").build();
        studentResponse=StudentResponse.builder().surname("test").name("test").email("test").phoneNumber("test").build();

    }
    @Test
    public void saveStudent() throws Exception {
        ResultActions response = mockMvc.perform(post("/api/v1/student/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(saveStudent)));
        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void getAllStudent() throws Exception {
        LinkedList<StudentResponse> studentResponses=new LinkedList<>();
        StudentResponse studentResponse=StudentResponse.builder().build();
        studentResponses.add(studentResponse);
        when(studentBusinessService.getAllStudent(10)).thenReturn(studentResponses);
        ResultActions response = mockMvc.perform(get("/api/v1/student/all")
                .contentType(MediaType.APPLICATION_JSON)
                .param("size","10"));
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.size()", CoreMatchers.is(studentResponses.size())));
    }
    @Test
    public void getStudentByPhone() throws Exception {
        String phone = "test";
        when(studentBusinessService.getStudentByPhone(phone)).thenReturn(studentResponse);

        ResultActions response = mockMvc.perform(get("/api/v1/student/search-by-phone")
                .contentType(MediaType.APPLICATION_JSON)
                        .param("phone","test")
                .content(objectMapper.writeValueAsString(studentResponse)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name", CoreMatchers.is(studentResponse.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.email", CoreMatchers.is(studentResponse.getEmail())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.phoneNumber", CoreMatchers.is(studentResponse.getPhoneNumber())));
    }
    @Test
    public void addStudent() throws Exception {
        ResultActions response = mockMvc.perform(post("/api/v1/student/add-course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addStudent)));
        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
