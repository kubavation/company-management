package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception.InvalidLeavePrivilegesPeriodException;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@ValueObject
@Getter
class LeavePrivilegesPeriod {

    private final LocalDate dateFrom;
    private final LocalDate dateTo;

    public LeavePrivilegesPeriod(LocalDate dateFrom, LocalDate dateTo) {

        Objects.requireNonNull(dateFrom, "Date from value not provided");
        Objects.requireNonNull(dateTo, "Date from value not provided");

        if (dateTo.isBefore(dateFrom)) {
            throw new InvalidLeavePrivilegesPeriodException();
        }

        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public boolean includes(LocalDate date) {

        if (Objects.isNull(date)) {
            return false;
        }

        return !date.isAfter(dateTo) && !date.isBefore(dateFrom);
    }

}
