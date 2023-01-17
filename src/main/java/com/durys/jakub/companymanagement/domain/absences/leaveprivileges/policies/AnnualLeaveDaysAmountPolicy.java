package com.durys.jakub.companymanagement.domain.absences.leaveprivileges.policies;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/*
   Policy for calculating number of days of annual leave based on employment length
*/


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnnualLeaveDaysAmountPolicy {

    public Integer calculate(int yearsOfEmployment) {
        if (yearsOfEmployment < 10) {
            return 20;
        }
        return 26;
    }
}
