package com.durys.jakub.companymanagement.domain.contracts.employment.permanent;

import com.durys.jakub.companymanagement.commons.events.DomainEvents;
import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.contracts.employment.NoticePeriod;
import com.durys.jakub.companymanagement.domain.contracts.event.EmploymentContractAssignedEvent;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;


public class PermanentEmployeeContract extends Contract implements EmploymentContract {

    public PermanentEmployeeContract(Builder builder) {
        super(new ContractId(UUID.randomUUID()), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), new PermanentEmployeeContractPeriod(builder.getFrom(), builder.getTo()));

        DomainEvents
                .instance()
                .publish(new EmploymentContractAssignedEvent(builder.getEmployeeId())); //todo
    }

    @Override
    public NoticePeriod noticePeriod(Period employmentPeriod) {
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
        return new PermanentEmployeeContractPeriod(from, to);
    }

    @Override
    protected LocalDate calculateEndDate(LocalDate dateOfTermination, Period employmentPeriod) {
        NoticePeriod noticePeriod = noticePeriod(employmentPeriod);
        return dateOfTermination.plus(noticePeriod.getNumber(), noticePeriod.getUnit());
    }


}
