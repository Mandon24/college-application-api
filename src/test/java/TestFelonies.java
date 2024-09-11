import criteria.Felonies;
import models.Applicant;
import models.Decision;
import models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFelonies {
    @Test
    public void whenApplicantHasFelonies_ExpectReject() {
        Felonies felonies = new Felonies();
        Applicant applicant = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, 1, "California");

        Results felonyResults = felonies.getDecision(applicant);
        Assertions.assertEquals(felonyResults.getDecision(), Decision.REJECT);
        Assertions.assertEquals(felonyResults.getReason(), "1 felonies found");
    }

    @Test
    public void whenApplicantHasNoFelonies_ExpectAccept() {
        Felonies felonies = new Felonies();
        Applicant applicant = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, 0, "California");

        Results felonyResults = felonies.getDecision(applicant);
        Assertions.assertEquals(felonyResults.getDecision(), Decision.ACCEPT);
        Assertions.assertEquals(felonyResults.getReason(), "No felonies found");
    }

}
