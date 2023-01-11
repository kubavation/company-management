package com.durys.jakub.companymanagement.domain.contracts.mandate;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.employment.permanent.PermanentEmployeeContractPeriod;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;


import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class MandateContract extends Contract {

    public MandateContract(Builder builder) {
        super(new ContractId(UUID.randomUUID()), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), new PermanentEmployeeContractPeriod(builder.getFrom(), builder.getTo()));
    }

    @Override
    protected ContractPeriod ofPeriod(LocalDate from, LocalDate to) {
        return new PermanentEmployeeContractPeriod(from, to);
    }

    @Override
    protected LocalDate calculateEndDate(LocalDate dateOfTermination, Period employmentPeriod) {
        //todo explore domain logic
        return dateOfTermination;
    }
}
