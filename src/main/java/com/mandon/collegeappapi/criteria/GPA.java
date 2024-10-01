package com.mandon.collegeappapi.criteria;

import com.mandon.collegeappapi.models.Applicant;
import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;

public class GPA implements IResults {
    @Override
    public Results getDecision(Applicant applicant) {
        double gpa90Threshold = (90 * applicant.getGpaScale()) / 100;
        double gpa70Threshold = (70 * applicant.getGpaScale()) / 100;

        if (applicant.getGpa() >= gpa90Threshold) {
            return new Results("Applicant meets good GPA standing requirement", Decision.ACCEPT);
        } else if (applicant.getGpa() < gpa70Threshold) {
            return new Results("Applicant does not meet GPA requirements", Decision.REJECT);
        } else {
            return new Results("Applicant GPA needs further review", Decision.REVIEW);
        }


    }
}
