package com.durys.jakub.companymanagement.domain.contracts.employment.fixedterm;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.contracts.employment.NoticePeriod;
import com.durys.jakub.companymanagement.domain.contracts.employment.trail.TrailEmploymentContractPeriod;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;
import com.durys.jakub.companymanagement.domain.employees.model.EmploymentPeriodService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;


public class FixedTermEmployeeContract extends Contract implements EmploymentContract {

    public FixedTermEmployeeContract(Builder builder) {
        super(new ContractId(UUID.randomUUID()), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), new FixedTermEmployeeContractPeriod(builder.getFrom(), builder.getTo()));
    }


    @Override
    public NoticePeriod noticePeriod(EmploymentPeriodService.EmploymentPeriod employmentPeriod) {
        if (employmentPeriod.getYears() >= 3) {
            return NoticePeriod.THREE_MONTHS;
        }
        if (employmentPeriod.getMonths() >= 6) {
            return NoticePeriod.ONE_MONTH;
        }
        return NoticePeriod.TWO_WEEKS;
    }


    @Override
    protected ContractPeriod ofPeriod(LocalDate from, LocalDate to) {
        return new FixedTermEmployeeContractPeriod(from, to);
    }

    @Override
    protected LocalDate calculateEndDate(LocalDate dateOfTermination,
                                         EmploymentPeriodService.EmploymentPeriod employmentPeriod) {
       NoticePeriod noticePeriod = noticePeriod(employmentPeriod);
       return dateOfTermination.plus(noticePeriod.getNumber(), noticePeriod.getUnit());
    }
}
