package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@ValueObject
@Getter
public class LeaveRequestPeriod {

    private final LocalDateTime dateFrom;
    private final LocalDateTime dateTo;

    private final Long numberOfDays;

    public LeaveRequestPeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {

        Objects.requireNonNull(dateFrom, "Date from value not provided");
        Objects.requireNonNull(dateTo, "Date from value not provided");

        if (dateTo.isBefore(dateFrom)) {
            throw new InvalidLeaveRequestPeriodException();
        }

        this.dateFrom = dateFrom;
        this.dateTo = dateTo;

        this.numberOfDays = ChronoUnit.DAYS.between(dateFrom, dateTo.plusDays(1));
    }

    public Long numberOfDays() {
        return numberOfDays;
    }

}
