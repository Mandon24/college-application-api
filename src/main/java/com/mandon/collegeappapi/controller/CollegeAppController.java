package com.mandon.collegeappapi.controller;

import com.mandon.collegeappapi.dto.ApplicantDTO;
import com.mandon.collegeappapi.dto.DecisionResponseDTO;
import com.mandon.collegeappapi.engine.ApplicationDecisionEngine;
import com.mandon.collegeappapi.exceptions.BadRequestException;
import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mandon.collegeappapi.models.Applicant;

import java.util.List;

@RestController
@RequestMapping("/api/college-app")
public class CollegeAppController {

    // POST endpoint to handle request to submit an application
    @PostMapping("/apply")
    public ResponseEntity<?> applyForCollege(@RequestBody @Valid ApplicantDTO applicantDTO) {
        try {
            Applicant applicant = Applicant.fromDTO(applicantDTO);
            ApplicationDecisionEngine decisionEngine = new ApplicationDecisionEngine(applicant);
            Decision decision = decisionEngine.runDecision();
            List<Results> applicantResults = decisionEngine.getApplicantResults();
            return new ResponseEntity<>(new DecisionResponseDTO(decision, applicantResults), HttpStatus.OK);

        } catch (BadRequestException e) {
            // Catch BadRequestException and return a 400 Bad Request with the custom message
            return new ResponseEntity<>("Bad request: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Application processing failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET endpoint to test the API
    @GetMapping("/status")
    public String status() {
        return "College Application API is running";
    }
}
