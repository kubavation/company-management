package com.durys.jakub.companymanagement.domain.absences.leaveprivileges.policies;

public class AnnualLeaveDaysAmountPolicy {

    /*
        Method for calculating number of days of annual leave based on employment length
     */

    public Integer calculate(int yearsOfEmployment) {
        if (yearsOfEmployment < 10) {
            return 20;
        }
        return 26;
    }
}
