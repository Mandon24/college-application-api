import models.Applicant;
import engine.ApplicationDecisionEngine;

public class CollegeApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Applicant michael = new Applicant("Michael", "Andon", 29, 3.8, 4.0, 2100, 25, 1, "California");
        ApplicationDecisionEngine michaelsApplication = new ApplicationDecisionEngine(michael);

        System.out.println(michaelsApplication.runDecision());
    }

}
