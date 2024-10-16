import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mandon.collegeappapi.CollegeApp;

import com.mandon.collegeappapi.exceptions.BadRequestException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes = CollegeApp.class)
@AutoConfigureMockMvc
public class TestCollegeAppController {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void testApplyForCollegeApproved() throws Exception {
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
    public void testApplyForCollegeRejected() throws Exception {
        // Create a sample payload
        String jsonPayload = "{"
                + "\"firstName\": \"john\","
                + "\"lastName\": \"Doe\","
                + "\"age\": -25,"
                + "\"gpa\": 2.0,"
                + "\"gpaScale\": 4.0,"
                + "\"satScore\": 1200,"
                + "\"actScore\": 30,"
                + "\"felonies\": true,"
                + "\"felonyDates\": [\"2022-10-23\", \"2020-10-23\"],"
                + "\"state\": \"California\""
                + "}";

        // Perform the POST request
        mockMvc.perform(post("/api/college-app/apply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.decision").value("REJECT")); // Adjust based on your Decision response
    }

    @Test
    public void testApplyForCollegeReview() throws Exception {
        // Create a sample payload
        String jsonPayload = "{"
                + "\"firstName\": \"John\","
                + "\"lastName\": \"Doe\","
                + "\"age\": 25,"
                + "\"gpa\": 3.2,"
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
                .andExpect(jsonPath("$.decision").value("REVIEW")); // Adjust based on your Decision response
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
