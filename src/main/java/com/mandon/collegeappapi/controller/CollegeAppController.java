package com.mandon.collegeappapi.controller;

import com.mandon.collegeappapi.dto.ApplicantDTO;
import com.mandon.collegeappapi.dto.DecisionResponseDTO;
import com.mandon.collegeappapi.engine.ApplicationDecisionEngine;
import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.mandon.collegeappapi.models.Applicant;

import java.util.List;

@RestController
@RequestMapping("/api/college-app")
public class CollegeAppController {

    // POST endpoint to handle request to submit an application
    @PostMapping("/apply")
    public DecisionResponseDTO applyForCollege(@RequestBody @Valid ApplicantDTO applicantDTO) {
        Applicant applicant = Applicant.fromDTO(applicantDTO);
        ApplicationDecisionEngine decisionEngine = new ApplicationDecisionEngine(applicant);
        Decision decision = decisionEngine.runDecision();
        List<Results> applicantResults = decisionEngine.getApplicantResults();
        return new DecisionResponseDTO(decision, applicantResults);  // Return the result of the decision com.mandon.collegeappapi.engine
    }

    // GET endpoint to test the API
    @GetMapping("/status")
    public String status() {
        return "College Application API is running";
    }
}
