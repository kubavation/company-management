package com.durys.jakub.companymanagement.domain.contracts.employment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Getter
public enum NoticePeriod {
    TWO_WEEKS,
    ONE_MONTH,
    THREE_MONTHS,
    THREE_DAYS,
    ONE_WEEK;

    private final ChronoUnit unit;
    private final Integer number;
}
