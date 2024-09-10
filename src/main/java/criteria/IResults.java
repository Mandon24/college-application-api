package criteria;

import models.Applicant;
import models.Results;

public interface IResults {
    Results getDecision(Applicant applicant);
}
