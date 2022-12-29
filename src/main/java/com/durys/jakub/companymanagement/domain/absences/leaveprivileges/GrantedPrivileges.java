package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception.InvalidLeavePrivilegesPeriodException;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@ValueObject
@Getter
class GrantedPrivileges {

    private final BigDecimal daysEntitled;
    private final BigDecimal hoursEntitled;

    public GrantedPrivileges(BigDecimal days, BigDecimal hours) {
        this.daysEntitled = days;
        this.hoursEntitled = hours;
    }

    public GrantedPrivileges(Integer days, Integer hours) {
        this.daysEntitled = new BigDecimal(days);
        this.hoursEntitled = new BigDecimal(hours);
    }

}
