package engine;

import criteria.Age;
import criteria.GPA;
import criteria.Felonies;
import criteria.StandardizedTests;
import criteria.Name;
import models.Applicant;
import models.Decision;

public class ApplicationDecisionEngine {
    Age applicantAge;
    GPA applicantGPA;
    Felonies applicantFelonies;
    Name applicantName;
    StandardizedTests applicantScores;

    public ApplicationDecisionEngine(Applicant applicant) {
        this.applicantAge = new Age(applicant.getAge(), applicant.getState());
        this.applicantGPA = new GPA(applicant.getGpa(), applicant.getGpaScale());
        this.applicantFelonies = new Felonies(applicant.getFelonies());
        this.applicantName = new Name(applicant.getFirstName(), applicant.getLastName());
        this.applicantScores = new StandardizedTests(applicant.getSatScore(), applicant.getActScore());
    }

    public Decision runDecision() {
        // check for Instance Accept
        if (this.isInstantAcceptCriteria()) {
            return Decision.ACCEPT;
        }
        // check for Instant Reject
        else if (this.isInstantRejectCriteria()) {
            return Decision.REJECT;
        }

        // check for Further Review
        return Decision.REVIEW;
    }

    /*
        - 1 or more felonies over the past 5 years.
        - High School criteria. GPA below 70% of scale provided on application.
        - The applicant claimed to be a negative age. E.g. "-20" years old.
        - The applicant first and/or last name are not in the form of first letter capitalized, the rest lower case.
     */
    public boolean isInstantRejectCriteria() {
        return this.applicantFelonies.hasFelonies() && this.applicantGPA.hasBadGPA() && this.applicantAge.hasNegativeAge() && this.applicantName.hasMalformedName();
    }

    public boolean hasAnyInstantRejectCriteria() {
        return this.applicantFelonies.hasFelonies() || this.applicantGPA.hasBadGPA() || this.applicantAge.hasNegativeAge() || this.applicantName.hasMalformedName();
    }

    /*
        - In-state (California) age 17 or older, and younger than 26; or older than 80 from any state.
        - High School criteria. GPA of 90% or higher of scale provided in their application. E.g. 3.6 on a 4.0 scale or 4.5 on a 5.0 scale.
        - SAT score greater than 1920 or ACT greater than 27. Note: Both or only one may be present in application.
        - No "instant reject" criteria is hit.
     */
    public boolean isInstantAcceptCriteria() {
        return this.applicantAge.qualifiableAge() && this.applicantScores.qualifiableScores() && this.applicantGPA.hasGoodGPA() && !this.hasAnyInstantRejectCriteria();

    }

}
