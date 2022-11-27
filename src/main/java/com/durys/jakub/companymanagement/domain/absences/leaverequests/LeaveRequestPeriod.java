package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@ValueObject
@Getter(AccessLevel.PACKAGE)
public class LeaveRequestPeriod {

    private final LocalDateTime dateFrom;
    private final LocalDateTime dateTo;

    public LeaveRequestPeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {

        Objects.requireNonNull(dateFrom, "invalid dateFrom parameter");
        Objects.requireNonNull(dateTo, "invalid dateTo parameter");


        if (dateTo.isBefore(dateFrom)) {
            throw new InvalidLeaveRequestPeriodException();
        }

        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Long numberOfDays() {
        return ChronoUnit.DAYS.between(dateFrom, dateTo.plusDays(1));
    }

}
