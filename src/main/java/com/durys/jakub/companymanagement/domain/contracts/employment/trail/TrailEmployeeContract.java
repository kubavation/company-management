package com.durys.jakub.companymanagement.domain.contracts.employment.trail;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.contracts.employment.NoticePeriod;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;
import com.durys.jakub.companymanagement.domain.employees.model.EmploymentPeriodService;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;


public class TrailEmployeeContract extends Contract implements EmploymentContract {

    public TrailEmployeeContract(Contract.Builder builder) {
        super(new ContractId(UUID.randomUUID()), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), new TrailEmploymentContractPeriod(builder.getFrom(), builder.getTo()));
    }

    //employment period based on contract duration
    @Override
    public NoticePeriod noticePeriod(EmploymentPeriodService.EmploymentPeriod employmentPeriod) {
        if (employmentPeriod.getMonths() == 3) {
            return NoticePeriod.TWO_WEEKS;
        }
        if (employmentPeriod.getDays() >= 14) {
            return NoticePeriod.ONE_WEEK;
        }
        return NoticePeriod.THREE_DAYS;
    }

    @Override
    protected ContractPeriod ofPeriod(LocalDate from, LocalDate to) {
        return new TrailEmploymentContractPeriod(from, to);
    }

    @Override
    protected LocalDate calculateEndDate(LocalDate dateOfTermination, EmploymentPeriodService.EmploymentPeriod employmentPeriod) {
        NoticePeriod noticePeriod = noticePeriod(employmentPeriod);
        return dateOfTermination.plus(noticePeriod.getNumber(), noticePeriod.getUnit());
    }
}
