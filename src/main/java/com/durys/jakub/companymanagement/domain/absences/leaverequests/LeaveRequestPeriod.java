package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@ValueObject
@Getter
public abstract class LeaveRequestPeriod {

    protected final LocalDateTime from;
    protected final LocalDateTime to;

    private final BigDecimal quantity;

    protected LeaveRequestPeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {

        Objects.requireNonNull(dateFrom, "Date from value not provided");
        Objects.requireNonNull(dateTo, "Date from value not provided");

        if (dateTo.isBefore(dateFrom)) {
            throw new InvalidLeaveRequestPeriodException();
        }

        this.from = dateFrom;
        this.to = dateTo;

        this.quantity = quantity();
    }

    protected abstract BigDecimal quantity();

}
