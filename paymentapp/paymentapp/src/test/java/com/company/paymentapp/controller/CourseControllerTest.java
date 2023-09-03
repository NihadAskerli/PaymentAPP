package com.company.paymentapp.controller;

import com.company.paymentapp.models.payload.course.CourseSave;
import com.company.paymentapp.models.payload.student.AddStudent;
import com.company.paymentapp.models.payload.student.SaveStudent;
import com.company.paymentapp.models.response.course.CourseResponse;
import com.company.paymentapp.models.response.student.StudentResponse;
import com.company.paymentapp.service.course.CourseBusinessServiceImpl;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(CourseController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CourseBusinessServiceImpl courseBusinessService;
    private CourseResponse courseResponse;
    private CourseSave courseSave;
    @BeforeEach
    public void init() {
        courseSave = CourseSave.builder().courseName("test").build();
        courseResponse=CourseResponse.builder().courseName("test").build();

    }
    @Test
    public void saveCourse() throws Exception {
        ResultActions response = mockMvc.perform(post("/api/v1/course/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(courseSave)));
        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void getCourseByName() throws Exception {
        String phone = "test";
        when(courseBusinessService.findCourseByName(phone)).thenReturn(courseResponse);

        ResultActions response = mockMvc.perform(get("/api/v1/course/search-by-name")
                .contentType(MediaType.APPLICATION_JSON)
                .param("name","test")
                .content(objectMapper.writeValueAsString(courseResponse)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.courseName", CoreMatchers.is(courseResponse.getCourseName())));
    }
}
