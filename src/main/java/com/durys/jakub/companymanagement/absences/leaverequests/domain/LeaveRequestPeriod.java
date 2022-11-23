package com.durys.jakub.companymanagement.absences.leaverequests.domain;

import com.durys.jakub.companymanagement.annotations.domain.ValueObject;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@ValueObject
class LeaveRequestPeriod {

    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    LeaveRequestPeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {

        if (Objects.isNull(dateFrom)) {
            throw new RuntimeException("Date from cannot be empty");
        }

        if (Objects.isNull(dateTo)) {
            throw new RuntimeException("Date to cannot be empty");
        }

        if (dateTo.isBefore(dateFrom)) {
            throw new RuntimeException("Date to cannot be before date from");
        }

        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Long numberOfDays() {
        return ChronoUnit.DAYS.between(dateFrom, dateTo.plusDays(1));
    }

}
