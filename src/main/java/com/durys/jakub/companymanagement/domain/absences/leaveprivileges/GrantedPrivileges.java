package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import lombok.Getter;

import java.math.BigDecimal;

@ValueObject
@Getter
class GrantedPrivileges {

    private final BigDecimal days;
    private final BigDecimal hours;

    GrantedPrivileges(BigDecimal days, BigDecimal hours) {
        this.days = days;
        this.hours = hours;
    }

    GrantedPrivileges(Integer days, Integer hours) {
        this.days = new BigDecimal(days);
        this.hours = new BigDecimal(hours);
    }

}
