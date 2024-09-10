import models.Applicant;
import engine.ApplicationDecisionEngine;

public class CollegeApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Applicant michael = new Applicant("", "Andon", -4, 2.5, 4.0, 1200, 25, 0, "California");
        ApplicationDecisionEngine michaelsApplication = new ApplicationDecisionEngine(michael);

        System.out.println(michaelsApplication.runDecision());
    }

}
