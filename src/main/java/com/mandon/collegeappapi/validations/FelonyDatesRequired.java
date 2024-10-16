package com.mandon.collegeappapi.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FelonyDatesValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FelonyDatesRequired {
    String message() default "Felony dates must be provided if felonies is true";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
