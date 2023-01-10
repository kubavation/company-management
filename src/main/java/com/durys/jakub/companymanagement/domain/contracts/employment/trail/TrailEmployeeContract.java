package com.durys.jakub.companymanagement.domain.contracts.employment.trail;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.contracts.employment.NoticePeriod;

import java.time.Period;


public class TrailEmployeeContract extends Contract implements EmploymentContract {

    //todo check if trail contract already exists for employee

    public TrailEmployeeContract(Contract.Builder builder) {
        super(builder.getContractId(), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), new TrailEmploymentContractPeriod(builder.getFrom(), builder.getTo()));
    }

    //employment period based on contract duration
    @Override
    public NoticePeriod noticePeriod(Period employmentPeriod) {
        if (employmentPeriod.getMonths() == 3) {
            return NoticePeriod.TWO_WEEKS;
        }
        if (employmentPeriod.getDays() >= 14) {
            return NoticePeriod.ONE_WEEK;
        }
        return NoticePeriod.THREE_DAYS;
    }

}
