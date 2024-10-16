package com.mandon.collegeappapi.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ScoreValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidScores {
    String message() default "Either SAT score or ACT score must be present";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
