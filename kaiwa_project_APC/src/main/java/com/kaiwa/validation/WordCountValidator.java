package com.kaiwa.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class WordCountValidator implements ConstraintValidator<WordCount, String> {

    private int min;
    private int max;

    @Override
    public void initialize(WordCount constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        String[] tokens = Arrays.stream(value.trim().split("\\s+"))
                                .filter(s -> !s.isEmpty())
                                .toArray(String[]::new);
        int count = tokens.length;
        return count >= min && count <= max;
    }
}
