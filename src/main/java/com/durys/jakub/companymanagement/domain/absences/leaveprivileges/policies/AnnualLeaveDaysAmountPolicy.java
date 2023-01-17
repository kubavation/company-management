package com.durys.jakub.companymanagement.domain.absences.leaveprivileges.policies;

public class AnnualLeaveDaysAmountPolicy {

    public Integer calculate(int yearsOfEmployment) {
        if (yearsOfEmployment < 10) {
            return 20;
        }
        return 26;
    }
}
