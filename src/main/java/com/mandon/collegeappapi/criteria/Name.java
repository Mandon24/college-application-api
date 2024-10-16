package com.mandon.collegeappapi.criteria;

import com.mandon.collegeappapi.models.Applicant;
import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;

public class Name implements IResults {

    @Override
    public Results getDecision(Applicant applicant) {
        // Check if the name is at least one character long and not null
        if (applicant.getFirstName() == null || applicant.getFirstName().isEmpty()) {
            return new Results("Empty first name", Decision.REJECT);
        } else if (applicant.getLastName() == null || applicant.getLastName().isEmpty()) {
            return new Results("Empty last name", Decision.REJECT);
        }
        // Check if the first character is uppercase and the rest are lowercase
        boolean okFirstName = Character.isUpperCase(applicant.getFirstName().charAt(0)) && applicant.getFirstName().substring(1).equals(applicant.getFirstName().substring(1).toLowerCase());
        boolean okLastName = Character.isUpperCase(applicant.getLastName().charAt(0)) && applicant.getLastName().substring(1).equals(applicant.getLastName().substring(1).toLowerCase());

        if (!(okFirstName && okLastName)) {
            return new Results(String.format("First and last name are malformed: %s %s", applicant.getFirstName(), applicant.getLastName()), Decision.REJECT);
        }
        return new Results("Applicant name is valid", Decision.ACCEPT);
    }
}
