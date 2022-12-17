package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@ValueObject
public class LeaveRequestDailyPeriod extends LeaveRequestPeriod {


    public LeaveRequestDailyPeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {
        super(dateFrom, dateTo);
    }

    @Override
    public BigDecimal quantity() {
        return BigDecimal.valueOf(ChronoUnit.DAYS.between(from, to) + 1);
    }

    @Override
    protected void validatePeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {

        if (dateTo.isBefore(dateFrom)) {
            throw new InvalidLeaveRequestPeriodException();
        }
    }
}
