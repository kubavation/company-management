package com.durys.jakub.companymanagement.domain.contracts.employment.permanent;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.contracts.employment.NoticePeriod;

import java.time.Period;


public class PermanentEmployeeContract extends Contract implements EmploymentContract {

    public PermanentEmployeeContract(Builder builder) {
        super(builder.getContractId(), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), new PermanentEmployeeContractPeriod(builder.getFrom(), builder.getTo()));
    }

    public NoticePeriod noticePeriod(Period employmentPeriod) {
        if (employmentPeriod.getYears() >= 3) {
            return NoticePeriod.THREE_MONTHS;
        }
        if (employmentPeriod.getMonths() >= 6) {
            return NoticePeriod.ONE_MONTH;
        }
        return NoticePeriod.TWO_WEEKS;
    }

}
