package com.mandon.collegeappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CollegeApp {

//    public static void main(String[] args) {
//        // Test an example
//        List<String> felonyDates = new ArrayList<>();
//        felonyDates.add("2018-10-23");
//
//        Applicant michael = new Applicant("Michael", "Andon", 25, 2.5, 4.0, 1200, 25, true, felonyDates, "California");
//        ApplicationDecisionEngine michaelsApplication = new ApplicationDecisionEngine(michael);
//
//        System.out.println(michaelsApplication.runDecision());
//    }

    public static void main(String[] args) {
        SpringApplication.run(CollegeApp.class, args);
    }

}
