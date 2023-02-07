package com.durys.jakub.companymanagement.domain.sharedkernel.util;

import lombok.NonNull;

import java.time.LocalTime;

public class TimeRangeValidator {

    public class InvalidDateRangeException extends RuntimeException {

        public InvalidDateRangeException(LocalTime from, LocalTime to) {
            super("Invalid time range. %s cannot be later than %s".formatted(from, to));
        }
    }

    private final LocalTime from;
    private final LocalTime to;

    private TimeRangeValidator(@NonNull LocalTime from, @NonNull LocalTime to) {
        this.from = from;
        this.to = to;
    }

    public static TimeRangeValidator of(LocalTime from, LocalTime to) {
        return new TimeRangeValidator(from, to);
    }

    public void validate() {
        if (from.isAfter(to)) {
            throw new InvalidDateRangeException(from, to);
        }
    }
}
