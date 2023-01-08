package com.durys.jakub.companymanagement.domain.contracts.employment.fixedterm;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.contracts.employment.trail.TrailEmploymentContractPeriod;


public class FixedTermEmployeeContract extends Contract implements EmploymentContract {

    public FixedTermEmployeeContract(Builder builder) {
        super(builder.getContractId(), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), todo);
    }
}
