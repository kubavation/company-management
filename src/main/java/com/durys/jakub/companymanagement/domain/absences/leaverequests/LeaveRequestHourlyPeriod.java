package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@ValueObject
public class LeaveRequestHourlyPeriod extends LeaveRequestPeriod {


    public static LeaveRequestHourlyPeriod of(@NonNull LocalDateTime from, @NonNull LocalDateTime to) {
        return new LeaveRequestHourlyPeriod(from, to);
    }

    private LeaveRequestHourlyPeriod(LocalDateTime from, LocalDateTime to) {
        super(from, to);
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
