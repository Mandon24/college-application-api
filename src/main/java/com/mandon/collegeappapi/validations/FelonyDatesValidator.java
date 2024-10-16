package com.mandon.collegeappapi.validations;

import com.mandon.collegeappapi.dto.ApplicantDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FelonyDatesValidator implements ConstraintValidator<FelonyDatesRequired, ApplicantDTO> {

    @Override
    public boolean isValid(ApplicantDTO applicantDTO, ConstraintValidatorContext context) {
        if (applicantDTO.isFelonies()) {
            // If felonies is true, felonyDates should not be empty
            return !applicantDTO.getFelonyDates().isEmpty();
        } else {
            // If felonies is false, felonyDates can be empty
            return true;
        }
    }
}
