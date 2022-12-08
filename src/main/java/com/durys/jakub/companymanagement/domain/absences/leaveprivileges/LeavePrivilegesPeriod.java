package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception.InvalidLeavePrivilegesPeriodException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@ValueObject
@Getter
public class LeavePrivilegesPeriod {

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

}