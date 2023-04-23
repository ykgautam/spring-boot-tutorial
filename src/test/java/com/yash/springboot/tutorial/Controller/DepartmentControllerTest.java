package com.yash.springboot.tutorial.Controller;

import com.yash.springboot.tutorial.enitity.Department;
import com.yash.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
        department=Department.builder()
                .departmentName("IT")
                .departmentCode("IT-06")
                .departmentAddress("Pune")
                .departmentId(1L)
                .build();
    }
    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment=Department.builder()
                .departmentName("IT")
                .departmentCode("IT-06")
                .departmentAddress("Pune")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"IT\",\n" +
                        "    \"departmentAddress\":\"Pune\",\n" +
                        "    \"departmentCode\":\"IT-06\"\n" +
                        "    \n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }
}