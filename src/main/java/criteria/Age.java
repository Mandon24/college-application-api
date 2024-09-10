package criteria;

import models.Applicant;
import models.Decision;
import models.Results;
import models.State;

public class Age implements IResults {

    @Override
    public Results getDecision(Applicant applicant) {
        if (applicant.getAge() < 0) {
            return new Results(String.format("Applicant has negative age: %d", applicant.getAge()), Decision.REJECT);
        } else if (applicant.getState().equalsIgnoreCase(State.CALIFORINA.name())) {
            if ((applicant.getAge() > 17 && applicant.getAge() < 26) || applicant.getAge() > 80) {
                return new Results("Applicant meets age requirements", Decision.ACCEPT);
            }
        } else {
            if (applicant.getAge() > 80) {
                return new Results("Age is above 80", Decision.ACCEPT);
            }
        }

        return new Results(String.format("Applicant's age criteria needs further review: %d", applicant.getAge()), Decision.REVIEW);
    }

}
