package com.apj.platform.auth.validators.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StandardDate {
    String message() default "date format should be in MM/dd/yyyy";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
