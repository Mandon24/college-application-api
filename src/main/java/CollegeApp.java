import models.Applicant;
import engine.ApplicationDecisionEngine;

import java.util.List;
import java.util.ArrayList;

public class CollegeApp {

    public static void main(String[] args) {
        // Test an example
        List<String> felonyDates = new ArrayList<>();
        felonyDates.add("2018-10-23");

        Applicant michael = new Applicant("Michael", "Andon", 25, 2.5, 4.0, 1200, 25, true, felonyDates, "California");
        ApplicationDecisionEngine michaelsApplication = new ApplicationDecisionEngine(michael);

        System.out.println(michaelsApplication.runDecision());
    }

}
