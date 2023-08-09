package pro.sky.java.course2.hw_spring_boot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import pro.sky.java.course2.hw_spring_boot.pojo.Employee;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminEmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getAllEmployeesTest() throws Exception {
        mockMvc.perform(get("/admin/employee/salary/all"))
                .andExpect(status().isOk())
                .andExpect( jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());

    }

    @Test
    void getSalarySumTest() throws Exception {
        JSONObject object = new JSONObject();
        object.put("salary", 100000);
        mockMvc.perform(get("/admin/employee/salary/sum"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.salary").isNumber());
    }

    @Test
    void getMinSalaryTest() throws Exception {
        JSONObject object = new JSONObject();
        object.put("salary", 100000);
        mockMvc.perform(get("/admin/employee/salary/min"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.salary").isNumber());
    }

    @Test
    void getMaxSalaryTest() throws Exception {
        JSONObject object = new JSONObject();
        object.put("salary", 100000);
        mockMvc.perform(get("/admin/employee/salary/withHighestSalary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.salary").isNumber());
    }

    @Test
    void getSalaryHigherThanAvgTest() throws Exception {
        JSONObject object = new JSONObject();
        object.put("salary", 100000);
        mockMvc.perform(get("/admin/employee/high-salary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.salary").isNumber());
    }

    @Test
    void getEmployeeByIdTest() throws Exception {
        mockMvc.perform(get("/admin/employee/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void getAllEmployeesWithMatchingPositionTest() throws Exception {
        mockMvc.perform(get("/admin/employee/position"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getEmployeeFullInfoTest() throws Exception {
        mockMvc.perform(get("/admin/employee/fullInfo/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    void getEmployeesInPageFormatTest() throws Exception {
        mockMvc.perform(get("/admin/employee/page"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void addEmployeeTest() throws Exception {
        JSONObject object = new JSONObject();
        object.put("id", 1);
        object.put("name", "ivan");
        object.put("salary", 10000.0);
        object.put("positionId", 2);
        mockMvc.perform(post("/admin/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(object.toString()))
                .andExpect(status().isOk());
    }

    @Test
    void updateEmployeeTest() throws Exception {
        JSONObject object = new JSONObject();
        object.put("name", "ivan");
        object.put("salary", 10000.0);
        object.put("positionId", 2);
        mockMvc.perform(put("/admin/employee/update/{id}",1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(object.toString()))
                .andExpect(status().isOk());
    }


    @Test
    void deleteEmployeeTest() throws Exception {
        mockMvc.perform(delete("/admin/employee/deleteBy/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void uploadTest() throws Exception {
        List<Employee> list = List.of(new Employee(3, "name", 10000, 1));
        String json = objectMapper.writeValueAsString(list);
        MockMultipartFile file = new MockMultipartFile("file", json.getBytes());
        mockMvc.perform(multipart("/admin/employee/upload")
                        .file(file))
                .andExpect(status().isOk());
    }


}

