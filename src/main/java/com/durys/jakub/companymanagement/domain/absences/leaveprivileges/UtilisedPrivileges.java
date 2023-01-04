package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import lombok.Getter;

import java.math.BigDecimal;

@ValueObject
@Getter
class UtilisedPrivileges {

    private final BigDecimal days;
    private final BigDecimal hours;

    UtilisedPrivileges(BigDecimal days, BigDecimal hours) {
        this.days = days;
        this.hours = hours;
    }

    UtilisedPrivileges(Integer days, Integer hours) {
        this.days = new BigDecimal(days);
        this.hours = new BigDecimal(hours);
    }

}
