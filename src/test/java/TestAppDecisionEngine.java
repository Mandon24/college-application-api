import com.mandon.collegeappapi.engine.ApplicationDecisionEngine;
import com.mandon.collegeappapi.models.Applicant;
import com.mandon.collegeappapi.models.Decision;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestAppDecisionEngine {
    private List<LocalDate> felonyDates;

    @BeforeEach
    public void init() {
        felonyDates = new ArrayList<>();
        felonyDates.add(LocalDate.parse("2020-10-23"));

    }

    @Test
    public void whenAppHasInstantAcceptCriteria_ExpectAccept() {
        Applicant applicant = new Applicant("Michael", "Andon", 22, 3.8, 4.0, 1930, 28, false, null, "California");
        ApplicationDecisionEngine appDecision = new ApplicationDecisionEngine(applicant);

        Assertions.assertEquals(appDecision.runDecision(), Decision.ACCEPT);
    }

    @Test
    public void whenAppHasInstantRejectCriteria_ExpectReject() {
        Applicant applicant = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, true, felonyDates, "California");
        ApplicationDecisionEngine appDecision = new ApplicationDecisionEngine(applicant);

        Assertions.assertEquals(appDecision.runDecision(), Decision.REJECT);
    }

    @Test
    public void whenAppHasNeitherInstantAcceptNorInstantRejectCriteria_ExpectReview() {
        Applicant applicant = new Applicant("", "Andon", 27, 3.8, 4.0, 1930, 29, false, null, "Nevada");
        ApplicationDecisionEngine appDecision = new ApplicationDecisionEngine(applicant);

        Assertions.assertEquals(appDecision.runDecision(), Decision.REVIEW);
    }
}
