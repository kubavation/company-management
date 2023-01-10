package com.durys.jakub.companymanagement.domain.contracts.employment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Getter
public enum NoticePeriod {
    TWO_WEEKS(ChronoUnit.DAYS, 14),
    ONE_MONTH(ChronoUnit.MONTHS, 1),
    THREE_MONTHS(ChronoUnit.MONTHS, 3),
    THREE_DAYS(ChronoUnit.DAYS, 3),
    ONE_WEEK(ChronoUnit.DAYS, 7);

    private final ChronoUnit unit;
    private final Integer number;
}
