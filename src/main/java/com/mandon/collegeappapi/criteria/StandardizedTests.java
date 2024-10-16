package com.mandon.collegeappapi.criteria;

import com.mandon.collegeappapi.models.Applicant;
import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;

public class StandardizedTests implements IResults {
    @Override
    public Results getDecision(Applicant applicant) {
        if (applicant.getSatScore() > 1920 || applicant.getActScore() > 27) {
            return new Results("Applicant sat/act score meets requirements", Decision.ACCEPT);
        }
        return new Results("Applicant does not meet sat/act score requirements", Decision.REJECT);
    }
}
