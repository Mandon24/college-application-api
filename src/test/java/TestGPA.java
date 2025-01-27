import com.mandon.collegeappapi.criteria.GPA;
import com.mandon.collegeappapi.models.Applicant;
import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestGPA {
    private List<LocalDate> felonyDates;

    @BeforeEach
    public void init() {
        felonyDates = new ArrayList<>();
        felonyDates.add(LocalDate.parse("2018-10-23"));

    }

    @Test
    public void whenGpaIsAbove90Threshold_ExpectAccept() {
        GPA applicantGpa = new GPA();
        Applicant applicant = new Applicant("", "Andon", -4, 3.8, 4.0, 1200, 25, true, felonyDates, "California");

        Results gpaResult = applicantGpa.getDecision(applicant);
        Assertions.assertEquals(gpaResult.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenGpaIsBelow70Threshold_ExpectReject() {
        GPA applicantGpa = new GPA();
        Applicant applicant = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, true, felonyDates, "California");

        Results gpaResult = applicantGpa.getDecision(applicant);
        Assertions.assertEquals(gpaResult.getDecision(), Decision.REJECT);
    }

    @Test
    public void whenGpaDoesNotMeetAcceptOrRejectCriteria_ExpectReview() {
        GPA applicantGpa = new GPA();
        Applicant applicant = new Applicant("", "Andon", -4, 2.9, 4.0, 1200, 25, true, felonyDates, "California");

        Results gpaResult = applicantGpa.getDecision(applicant);
        Assertions.assertEquals(gpaResult.getDecision(), Decision.REVIEW);
    }
}
