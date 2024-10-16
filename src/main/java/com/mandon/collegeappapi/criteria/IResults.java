package com.mandon.collegeappapi.criteria;

import com.mandon.collegeappapi.models.Applicant;
import com.mandon.collegeappapi.models.Results;

public interface IResults {
    Results getDecision(Applicant applicant);
}
