package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@ValueObject
public class LeaveRequestHourlyPeriod extends LeaveRequestPeriod {


    public LeaveRequestHourlyPeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {
        super(dateFrom, dateTo);
    }

    @Override
    public BigDecimal quantity() {
        return BigDecimal.valueOf(ChronoUnit.HOURS.between(from, to));
    }

    @Override
    protected void validatePeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {

        if (!dateTo.isAfter(dateFrom)) {
            throw new InvalidLeaveRequestPeriodException();
        }
        
    }
}
