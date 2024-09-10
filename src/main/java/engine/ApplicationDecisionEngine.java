package engine;

import criteria.Age;
import criteria.GPA;
import criteria.Felonies;
import criteria.StandardizedTests;
import criteria.Name;
import models.Applicant;
import models.Decision;
import models.Results;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDecisionEngine {
    Applicant applicant;
    Age applicantAge = new Age();
    GPA applicantGPA = new GPA();
    Felonies applicantFelonies = new Felonies();
    Name applicantName = new Name();
    StandardizedTests applicantScores = new StandardizedTests();
    List<Results> applicantResults = new ArrayList<>();

    public ApplicationDecisionEngine(Applicant applicant) {
        this.applicant = applicant;
    }

    public Decision runDecision() {
        // check for Instance Accept
        if (this.isInstantAcceptCriteria()) {
            return Decision.ACCEPT;
        }
        // check for Instant Reject
        else if (this.isInstantRejectCriteria()) {
            System.out.println("Applicant does not meet acceptance requirements: ");
            for (Results r : this.applicantResults) {
                System.out.println(r.getReason());
            }
            return Decision.REJECT;
        }

        // check for Further Review
        System.out.println("Applicant's application needs further review: ");
        for (Results r : this.applicantResults) {
            System.out.println(r.getReason());
        }
        return Decision.REVIEW;
    }

    /*
        - 1 or more felonies over the past 5 years.
        - High School criteria. GPA below 70% of scale provided on application.
        - The applicant claimed to be a negative age. E.g. "-20" years old.
        - The applicant first and/or last name are not in the form of first letter capitalized, the rest lower case.
     */
    public boolean isInstantRejectCriteria() {
        Results felonyResults = this.applicantFelonies.getDecision(this.applicant);
        Results gpaResults = this.applicantGPA.getDecision(this.applicant);
        Results ageResults = this.applicantAge.getDecision(this.applicant);
        Results nameResults = this.applicantName.getDecision(this.applicant);
        this.applicantResults.add(felonyResults);
        this.applicantResults.add(gpaResults);
        this.applicantResults.add(ageResults);
        this.applicantResults.add(nameResults);

        return felonyResults.getDecision().equals(Decision.REJECT)
                && gpaResults.getDecision().equals(Decision.REJECT)
                && ageResults.getDecision().equals(Decision.REJECT)
                && nameResults.getDecision().equals(Decision.REJECT);
    }

    public boolean hasAnyInstantRejectCriteria() {
        Results felonyResults = this.applicantFelonies.getDecision(this.applicant);
        Results gpaResults = this.applicantGPA.getDecision(this.applicant);
        Results ageResults = this.applicantAge.getDecision(this.applicant);
        Results nameResults = this.applicantName.getDecision(this.applicant);
        this.applicantResults.add(felonyResults);
        this.applicantResults.add(gpaResults);
        this.applicantResults.add(ageResults);
        this.applicantResults.add(nameResults);

        return felonyResults.getDecision().equals(Decision.REJECT)
                || gpaResults.getDecision().equals(Decision.REJECT)
                || ageResults.getDecision().equals(Decision.REJECT)
                || nameResults.getDecision().equals(Decision.REJECT);
    }

    /*
        - In-state (California) age 17 or older, and younger than 26; or older than 80 from any state.
        - High School criteria. GPA of 90% or higher of scale provided in their application. E.g. 3.6 on a 4.0 scale or 4.5 on a 5.0 scale.
        - SAT score greater than 1920 or ACT greater than 27. Note: Both or only one may be present in application.
        - No "instant reject" criteria is hit.
     */
    public boolean isInstantAcceptCriteria() {
        Results gpaResults = this.applicantGPA.getDecision(this.applicant);
        Results scoreResults = this.applicantScores.getDecision(this.applicant);
        Results ageResults = this.applicantAge.getDecision(this.applicant);

        return gpaResults.getDecision().equals(Decision.ACCEPT)
                && scoreResults.getDecision().equals(Decision.ACCEPT)
                && ageResults.getDecision().equals(Decision.ACCEPT)
                && !this.hasAnyInstantRejectCriteria();

    }

}
