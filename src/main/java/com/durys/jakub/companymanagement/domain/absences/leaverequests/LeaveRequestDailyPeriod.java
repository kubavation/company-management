package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@ValueObject
public class LeaveRequestDailyPeriod extends LeaveRequestPeriod {


    public static LeaveRequestDailyPeriod of(LocalDate from, LocalDate to) {
        Objects.requireNonNull(from, "Date from value not provided");
        Objects.requireNonNull(to, "Date from value not provided");

        return new LeaveRequestDailyPeriod(from, to);
    }

    private LeaveRequestDailyPeriod(LocalDate dateFrom, LocalDate dateTo) {
        super(dateFrom.atStartOfDay(), dateTo.atStartOfDay());
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
