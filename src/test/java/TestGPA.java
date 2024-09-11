import criteria.GPA;
import models.Applicant;
import models.Decision;
import models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGPA {
    @Test
    public void whenGpaIsAbove90Threshold_ExpectAccept() {
        GPA applicantGpa = new GPA();
        Applicant applicant = new Applicant("", "Andon", -4, 3.8, 4.0, 1200, 25, 1, "California");

        Results gpaResult = applicantGpa.getDecision(applicant);
        Assertions.assertEquals(gpaResult.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenGpaIsBelow70Threshold_ExpectReject() {
        GPA applicantGpa = new GPA();
        Applicant applicant = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, 1, "California");

        Results gpaResult = applicantGpa.getDecision(applicant);
        Assertions.assertEquals(gpaResult.getDecision(), Decision.REJECT);
    }

    @Test
    public void whenGpaDoesNotMeetAcceptOrRejectCriteria_ExpectReview() {
        GPA applicantGpa = new GPA();
        Applicant applicant = new Applicant("", "Andon", -4, 2.9, 4.0, 1200, 25, 1, "California");

        Results gpaResult = applicantGpa.getDecision(applicant);
        Assertions.assertEquals(gpaResult.getDecision(), Decision.REVIEW);
    }
}
