package com.durys.jakub.companymanagement.domain.contracts.mandate;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.employment.permanent.PermanentEmployeeContractPeriod;

import java.util.UUID;

public class MandateContract extends Contract {

    public MandateContract(Builder builder) {
        super(new ContractId(UUID.randomUUID()), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), new PermanentEmployeeContractPeriod(builder.getFrom(), builder.getTo()));
    }
}
