package com.mandon.collegeappapi.models;

public class Results {

    String reason;
    Decision decision;

    public Results(String reason, Decision decision) {
        setReason(reason);
        setDecision(decision);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

}
