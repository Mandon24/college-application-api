package com.mandon.collegeappapi.controller;

import com.mandon.collegeappapi.engine.ApplicationDecisionEngine;
import com.mandon.collegeappapi.models.Decision;
import org.springframework.web.bind.annotation.*;
import com.mandon.collegeappapi.models.Applicant;

@RestController
@RequestMapping("/api/college-app")
public class CollegeAppController {

    // POST endpoint to handle request to submit an application
    @PostMapping("/apply")
    public Decision applyForCollege(@RequestBody Applicant applicant) {
        ApplicationDecisionEngine decisionEngine = new ApplicationDecisionEngine(applicant);
        return decisionEngine.runDecision();  // Return the result of the decision com.mandon.collegeappapi.engine
    }

    // GET endpoint to test the API
    @GetMapping("/status")
    public String status() {
        return "College Application API is running";
    }
}
