import com.mandon.collegeappapi.criteria.Age;
import com.mandon.collegeappapi.models.Applicant;
import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAge {
    private List<String> felonyDates;

    @BeforeEach
    public void init() {
        felonyDates = new ArrayList<>();
        felonyDates.add("2018-10-23");

    }

    @Test
    public void whenApplicantIsInstateAndAgeIsWithin17and26_ExpectAccept() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", 20, 3.3, 4.0, 1200, 25, true, felonyDates, "California");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenApplicantIsInstateAndAgeIsOver80_ExpectAccept() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", 81, 3.3, 4.0, 1200, 25, true, felonyDates, "California");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenApplicantIsOutOfStateAndAgeIsOver80_ExpectAccept() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", 81, 3.3, 4.0, 1200, 25, true, felonyDates, "Nevada");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenAgeIsNegative_ExpectReject() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", -20, 3.3, 4.0, 1200, 25, true, felonyDates, "California");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.REJECT);
    }

    @Test
    public void whenAgeIsOutOfCriteria_ExpectReview() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", 27, 3.3, 4.0, 1200, 25, true, felonyDates, "California");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.REVIEW);
    }
}
