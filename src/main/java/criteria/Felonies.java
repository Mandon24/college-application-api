package criteria;

import models.Applicant;
import models.Decision;
import models.Results;

public class Felonies implements IResults {

    @Override
    public Results getDecision(Applicant applicant) {
        if (applicant.getFelonies() >= 1) {
            return new Results(String.format("%d felonies found", applicant.getFelonies()), Decision.REJECT);
        }
        return new Results("No felonies found", Decision.ACCEPT);
    }
}
