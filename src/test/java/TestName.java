import criteria.Name;
import models.Applicant;
import models.Decision;
import models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestName {
    private List<String> felonyDates;

    @BeforeEach
    public void init() {
        felonyDates = new ArrayList<>();
        felonyDates.add("2018-10-23");

    }

    @Test
    public void whenNameIsMalformed_ExpectReject() {
        Name applicantName = new Name();
        Applicant applicant = new Applicant("", "Andon", 81, 3.3, 4.0, 1200, 25, true, felonyDates, "California");

        Results nameResults = applicantName.getDecision(applicant);
        Assertions.assertEquals(nameResults.getDecision(), Decision.REJECT);

    }

    @Test
    public void whenNameIsNotMalformed_ExpectAccept() {
        Name applicantName = new Name();
        Applicant applicant = new Applicant("Michael", "Andon", 81, 3.3, 4.0, 1200, 25, true, felonyDates, "California");

        Results nameResults = applicantName.getDecision(applicant);
        Assertions.assertEquals(nameResults.getDecision(), Decision.ACCEPT);
    }
}
