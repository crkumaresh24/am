package com.apj.platform.auth.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.apj.platform.auth.validators.constraints.StandardDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StandardDateValidator implements ConstraintValidator<StandardDate, String> {

    private static final String DATE_PATTERN = "MM/dd/yyyy";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        try {
            sdf.setLenient(false);
            sdf.parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
