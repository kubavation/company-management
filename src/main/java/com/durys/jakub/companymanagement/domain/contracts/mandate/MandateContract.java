package com.durys.jakub.companymanagement.domain.contracts.mandate;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.employment.permanent.PermanentEmployeeContractPeriod;

public class MandateContract extends Contract {

    public MandateContract(Builder builder) {
        super(builder.getContractId(), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), new PermanentEmployeeContractPeriod(builder.getFrom(), builder.getTo()));
    }
}
