import criteria.Felonies;
import models.Applicant;
import models.Decision;
import models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestFelonies {
    private List<String> felonyDates;

    @BeforeEach
    public void init() {
        felonyDates = new ArrayList<>();
        felonyDates.add("2018-10-23");

    }

    @Test
    public void whenApplicantHasFelonies_ExpectReject() {
        Felonies felonies = new Felonies();
        Applicant applicant = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, true, felonyDates, "California");

        Results felonyResults = felonies.getDecision(applicant);
        Assertions.assertEquals(felonyResults.getDecision(), Decision.REJECT);
        Assertions.assertEquals(felonyResults.getReason(), "1 felonies found");
    }

    @Test
    public void whenApplicantHasNoFelonies_ExpectAccept() {
        Felonies felonies = new Felonies();
        Applicant applicant = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, false, null, "California");

        Results felonyResults = felonies.getDecision(applicant);
        Assertions.assertEquals(felonyResults.getDecision(), Decision.ACCEPT);
        Assertions.assertEquals(felonyResults.getReason(), "No felonies found");
    }

}
