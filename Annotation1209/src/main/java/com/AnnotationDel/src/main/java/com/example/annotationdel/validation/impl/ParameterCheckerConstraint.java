package com.example.annotationdel.validation.impl;

import com.example.annotationdel.validation.ann.ParameterChecker;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class ParameterCheckerConstraint implements ConstraintValidator<ParameterChecker, String> {
//      private static final String PATTERN = "^[a-zA-Z]{3}$";
    private static final String PATTERN = "^[А-Яа-яA-Za-z\\s'-]+$";

    @Override
    public void initialize(ParameterChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String text, ConstraintValidatorContext context) {
        return Optional.ofNullable(text)
                .filter(t -> !t.isBlank())
                .map(tex -> tex.matches(PATTERN))
                .orElse(false);
    }
}