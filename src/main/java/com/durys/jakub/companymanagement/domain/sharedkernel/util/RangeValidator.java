package com.durys.jakub.companymanagement.domain.sharedkernel.util;

import java.time.LocalDate;
import java.time.temporal.Temporal;

public class RangeValidator<T extends Temporal> {

    private final RangeValidationStrategy validationStrategy;

    public RangeValidator(Class<T> clazz) {
        if (LocalDate.class.equals(clazz)) {
            validationStrategy = new DateRangeValidator();
        } else {
            throw new RuntimeException();
        }

    }

    public void validate(T from, T to) {
        validationStrategy.validate(from, to);
    }
}
