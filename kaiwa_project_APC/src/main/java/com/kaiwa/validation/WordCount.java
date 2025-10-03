package com.kaiwa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WordCountValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface WordCount {
    String message() default "word count must be between {min} and {max}";
    int min() default 7;
    int max() default 15;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
