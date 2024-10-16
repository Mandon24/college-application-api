import com.mandon.collegeappapi.criteria.StandardizedTests;
import com.mandon.collegeappapi.models.Applicant;
import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestScores {
    private List<LocalDate> felonyDates;

    @BeforeEach
    public void init() {
        felonyDates = new ArrayList<>();
        felonyDates.add(LocalDate.parse("2018-10-23"));

    }

    @Test
    public void whenSatScoreAbove1920AndActScoreBelow27_ExpectAccept() {
        StandardizedTests applicantScores = new StandardizedTests();
        Applicant applicant = new Applicant("Michael", "Andon", -4, 3.8, 4.0, 1930, 25, true, felonyDates, "California");

        Results scoresResults = applicantScores.getDecision(applicant);
        Assertions.assertEquals(scoresResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenSatScoreBelow1920AndActScoreAbove27_ExpectAccept() {
        StandardizedTests applicantScores = new StandardizedTests();
        Applicant applicant = new Applicant("Michael", "Andon", -4, 3.8, 4.0, 1910, 28, true, felonyDates, "California");

        Results scoresResults = applicantScores.getDecision(applicant);
        Assertions.assertEquals(scoresResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenSatScoreBelow1920AndActScoreBelow27_ExpectReject() {
        StandardizedTests applicantScores = new StandardizedTests();
        Applicant applicant = new Applicant("Michael", "Andon", -4, 3.8, 4.0, 1910, 25, true, felonyDates, "California");

        Results scoresResults = applicantScores.getDecision(applicant);
        Assertions.assertEquals(scoresResults.getDecision(), Decision.REJECT);
    }

    @Test
    public void whenSatScoreAbove1920AndActScoreAbove27_ExpectAccept() {
        StandardizedTests applicantScores = new StandardizedTests();
        Applicant applicant = new Applicant("Michael", "Andon", -4, 3.8, 4.0, 1930, 28, true, felonyDates, "California");

        Results scoresResults = applicantScores.getDecision(applicant);
        Assertions.assertEquals(scoresResults.getDecision(), Decision.ACCEPT);
    }
}
