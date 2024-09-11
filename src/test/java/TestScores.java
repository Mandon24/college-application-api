import criteria.StandardizedTests;
import models.Applicant;
import models.Decision;
import models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestScores {
    @Test
    public void whenSatScoreAbove1920AndActScoreBelow27_ExpectAccept() {
        StandardizedTests applicantScores = new StandardizedTests();
        Applicant applicant = new Applicant("Michael", "Andon", -4, 3.8, 4.0, 1930, 25, 1, "California");

        Results scoresResults = applicantScores.getDecision(applicant);
        Assertions.assertEquals(scoresResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenSatScoreBelow1920AndActScoreAbove27_ExpectAccept() {
        StandardizedTests applicantScores = new StandardizedTests();
        Applicant applicant = new Applicant("Michael", "Andon", -4, 3.8, 4.0, 1910, 28, 1, "California");

        Results scoresResults = applicantScores.getDecision(applicant);
        Assertions.assertEquals(scoresResults.getDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenSatScoreBelow1920AndActScoreBelow27_ExpectReject() {
        StandardizedTests applicantScores = new StandardizedTests();
        Applicant applicant = new Applicant("Michael", "Andon", -4, 3.8, 4.0, 1910, 25, 1, "California");

        Results scoresResults = applicantScores.getDecision(applicant);
        Assertions.assertEquals(scoresResults.getDecision(), Decision.REJECT);
    }

    @Test
    public void whenSatScoreAbove1920AndActScoreAbove27_ExpectAccept() {
        StandardizedTests applicantScores = new StandardizedTests();
        Applicant applicant = new Applicant("Michael", "Andon", -4, 3.8, 4.0, 1930, 28, 1, "California");

        Results scoresResults = applicantScores.getDecision(applicant);
        Assertions.assertEquals(scoresResults.getDecision(), Decision.ACCEPT);
    }
}
