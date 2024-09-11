import criteria.Age;
import models.Applicant;
import models.Decision;
import models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAge {
    @Test
    public void whenApplicantIsInstateAndAgeIsWithin17and26_ExpectAccept() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", 20, 3.3, 4.0, 1200, 25, 1, "California");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenApplicantIsInstateAndAgeIsOver80_ExpectAccept() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", 81, 3.3, 4.0, 1200, 25, 1, "California");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenApplicantIsOutOfStateAndAgeIsOver80_ExpectAccept() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", 81, 3.3, 4.0, 1200, 25, 1, "Nevada");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenAgeIsNegative_ExpectReject() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", -20, 3.3, 4.0, 1200, 25, 1, "California");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.REJECT);
    }

    @Test
    public void whenAgeIsOutOfCriteria_ExpectReview() {
        Age applicantAge = new Age();
        Applicant applicant = new Applicant("", "Andon", 27, 3.3, 4.0, 1200, 25, 1, "California");

        Results ageResults = applicantAge.getDecision(applicant);
        Assertions.assertEquals(ageResults.getDecision(), Decision.REVIEW);
    }
}
