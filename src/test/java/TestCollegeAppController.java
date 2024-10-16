import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mandon.collegeappapi.CollegeApp;
import com.mandon.collegeappapi.dto.ApplicantDTO;
import com.mandon.collegeappapi.models.Decision;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = CollegeApp.class)
@AutoConfigureMockMvc
public class TestCollegeAppController {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void testApplyForCollege() throws Exception {
        // Create a sample payload
        String jsonPayload = "{"
                + "\"firstName\": \"John\","
                + "\"lastName\": \"Doe\","
                + "\"age\": 25,"
                + "\"gpa\": 3.6,"
                + "\"gpaScale\": 4.0,"
                + "\"satScore\": 1200,"
                + "\"actScore\": 30,"
                + "\"felonies\": false,"
                + "\"felonyDates\": [],"
                + "\"state\": \"California\""
                + "}";

        // Perform the POST request
        mockMvc.perform(post("/api/college-app/apply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.decision").value("ACCEPT")); // Adjust based on your Decision response
    }

    @Test
    public void testApplyForCollegeWithInvalidData() throws Exception {
        // Create an invalid sample payload (e.g., missing required fields)
        String invalidPayload = "{\"firstName\": \"\", \"lastName\": \"Doe\", \"age\": -1}";

        // Perform the POST request
        mockMvc.perform(post("/api/college-app/apply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidPayload))
                .andExpect(status().isBadRequest()); // Expecting a 400 Bad Request
    }
}
