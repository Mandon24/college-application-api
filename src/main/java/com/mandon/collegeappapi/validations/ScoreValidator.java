package com.mandon.collegeappapi.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.mandon.collegeappapi.dto.ApplicantDTO;

public class ScoreValidator implements ConstraintValidator<ValidScores, ApplicantDTO> {

    @Override
    public boolean isValid(ApplicantDTO applicantDTO, ConstraintValidatorContext context) {
        return (applicantDTO.getSatScore() != null && applicantDTO.getSatScore() > 0) ||
                (applicantDTO.getActScore() != null && applicantDTO.getActScore() > 0);
    }
}
