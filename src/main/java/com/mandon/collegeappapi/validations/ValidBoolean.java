package com.mandon.collegeappapi.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BooleanValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBoolean {
    String message() default "Value must be true or false";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
