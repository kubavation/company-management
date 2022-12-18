package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@ValueObject
@Getter
public abstract class LeaveRequestPeriod {

    protected final LocalDateTime from;
    protected final LocalDateTime to;

    private final BigDecimal quantity;

    protected LeaveRequestPeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {

        validatePeriod(dateFrom, dateTo);

        this.from = dateFrom;
        this.to = dateTo;

        this.quantity = quantity();
    }

    protected abstract BigDecimal quantity();

    protected abstract void validatePeriod(LocalDateTime dateFrom, LocalDateTime dateTo);

}
