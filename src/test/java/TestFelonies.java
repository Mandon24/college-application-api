import com.mandon.collegeappapi.criteria.Felonies;
import com.mandon.collegeappapi.models.Applicant;
import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestFelonies {
    private List<LocalDate> felonyDates;

    @BeforeEach
    public void init() {
        felonyDates = new ArrayList<>();
        felonyDates.add(LocalDate.parse("2020-10-23"));

    }

    @Test
    public void whenApplicantHasFelonies_ExpectReject() {
        Felonies felonies = new Felonies();
        Applicant applicant = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, true, felonyDates, "California");

        Results felonyResults = felonies.getDecision(applicant);
        Assertions.assertEquals(felonyResults.getDecision(), Decision.REJECT);
        Assertions.assertEquals(felonyResults.getReason(), "1 felonies found over the past 5 years: 10/23/2020");
    }

    @Test
    public void whenApplicantHasNoFelonies_ExpectAccept() {
        Felonies felonies = new Felonies();
        Applicant applicant = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, false, null, "California");

        Results felonyResults = felonies.getDecision(applicant);
        Assertions.assertEquals(felonyResults.getDecision(), Decision.ACCEPT);
        Assertions.assertEquals(felonyResults.getReason(), "No felonies found over the past 5 years");
    }

}
