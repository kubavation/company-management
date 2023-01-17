package com.durys.jakub.companymanagement.domain.sharedkernel.util;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DateRangeValidator {

    public class InvalidDateRangeException extends RuntimeException {

        public InvalidDateRangeException(LocalDate from, LocalDate to) {
            super("Invalid date range. %s cannot be later than %s".formatted(from, to));
        }
    }

    private final LocalDate from;
    private final LocalDate to;

    public static DateRangeValidator of(LocalDate from, LocalDate to) {
        return new DateRangeValidator(from, to);
    }

    public void validate() {
        if (from.isAfter(to)) {
            throw new InvalidDateRangeException(from, to);
        }
    }
}
