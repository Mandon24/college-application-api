package com.mandon.collegeappapi.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BooleanValidator implements ConstraintValidator<ValidBoolean, Boolean> {

    @Override
    public boolean isValid(Boolean value, ConstraintValidatorContext context) {
        return value != null; // Ensures the value is explicitly set to true or false
    }
}
