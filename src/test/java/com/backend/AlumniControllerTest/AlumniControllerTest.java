package com.backend.AlumniControllerTest;

import com.backend.controller.AlumniController;
import com.backend.request.AlumniSearchRequest;
import com.backend.response.AlumniResponse;
import com.backend.service.AlumniService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlumniController.class)
class AlumniControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlumniService alumniService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSearchAlumni() throws Exception {
        AlumniSearchRequest request = new AlumniSearchRequest();
        request.setUniversity("Test University");
        request.setDesignation("Engineer");

        List<AlumniResponse> mockResponse = List.of(
                new AlumniResponse("John Doe", "Engineer", "Test University", "New York", "Headline 1", 2015),
                new AlumniResponse("Jane Smith", "Analyst", "Test University", "Chicago", "Headline 2", 2016)
        );

        Mockito.when(alumniService.searchAndSaveAlumni(any(AlumniSearchRequest.class)))
                .thenReturn(mockResponse);

        mockMvc.perform(post("/api/alumni/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("success"))
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.data[0].name").value("John Doe"))
                .andExpect(jsonPath("$.data[1].name").value("Jane Smith"));
    }

    @Test
    void testGetAllAlumni() throws Exception {
        List<AlumniResponse> mockResponse = List.of(
                new AlumniResponse("John Doe", "Engineer", "Test University", "New York", "Headline 1", 2015)
        );

        Mockito.when(alumniService.getAllAlumni()).thenReturn(mockResponse);

        mockMvc.perform(get("/api/alumni/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("success"))
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].name").value("John Doe"));
    }
}
