package pro.sky.java.course2.hw_spring_boot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "Ivan", roles = "ADMIN", password = "Ivan")
public class ReportControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void whenAddReport() throws Exception {
        mockMvc.perform(post("/report/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber());
    }

    @Test
    void WhenGetReportById() throws Exception {
        mockMvc.perform(get("/report/report/{id}", 1))
                .andExpect(status().isOk());

    }
}
