package com.mandon.collegeappapi.dto;

import com.mandon.collegeappapi.models.Decision;
import com.mandon.collegeappapi.models.Results;

import java.util.List;

public class DecisionResponseDTO {
    private String decision;
    private String results;

    public DecisionResponseDTO(Decision decision, List<Results> applicantResults) {
        setDecision(decision.name());
        setResults(applicantResults.toString());
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
