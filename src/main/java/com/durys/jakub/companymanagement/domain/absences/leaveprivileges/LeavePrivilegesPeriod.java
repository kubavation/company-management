package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception.InvalidLeavePrivilegesPeriodException;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Objects;

@ValueObject
@Getter
class LeavePrivilegesPeriod {

    private final LocalDate dateFrom;
    private final LocalDate dateTo;

    public LeavePrivilegesPeriod(@NonNull LocalDate dateFrom,@NonNull LocalDate dateTo) {

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
