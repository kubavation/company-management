package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception.InvalidLeavePrivilegesPeriodException;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@ValueObject
@Getter
public class GrantedPrivileges {

    private Integer daysEntitled;
    private Integer hoursEntitled;

    public GrantedPrivileges(Integer days, Integer hours) {
        this.daysEntitled = days;
        this.hoursEntitled = hours;
    }

}
