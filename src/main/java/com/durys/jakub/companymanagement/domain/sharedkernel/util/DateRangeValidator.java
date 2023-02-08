package com.durys.jakub.companymanagement.domain.sharedkernel.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class DateRangeValidator implements RangeValidator<LocalDate> {

    public class InvalidDateRangeException extends RuntimeException {

        public InvalidDateRangeException(LocalDate from, LocalDate to) {
            super("Invalid date range. %s cannot be later than %s".formatted(from, to));
        }
    }

    @Override
    public void validate(LocalDate from, LocalDate to) {
        if (from.isAfter(to)) {
            throw new InvalidDateRangeException(from, to);
        }
    }

}
