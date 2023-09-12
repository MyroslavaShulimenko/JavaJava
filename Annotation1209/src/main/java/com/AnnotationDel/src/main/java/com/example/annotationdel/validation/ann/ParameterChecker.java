package com.example.annotationdel.validation.ann;


import com.example.annotationdel.validation.impl.ParameterCheckerConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ParameterCheckerConstraint.class})
public @interface ParameterChecker {
    String message() default "Request has to consist of 3 letters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}