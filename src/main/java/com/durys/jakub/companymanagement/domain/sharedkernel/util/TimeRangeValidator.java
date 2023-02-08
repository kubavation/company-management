package com.durys.jakub.companymanagement.domain.sharedkernel.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class TimeRangeValidator implements RangeValidator<LocalTime> {

    public class InvalidTimeRangeException extends RuntimeException {

        public InvalidTimeRangeException(LocalTime from, LocalTime to) {
            super("Invalid time range. %s cannot be later than %s".formatted(from, to));
        }
    }

    @Override
    public void validate(LocalTime from, LocalTime to) {
        if (from.isAfter(to)) {
            throw new InvalidTimeRangeException(from, to);
        }
    }
}
