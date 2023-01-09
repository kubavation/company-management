package com.durys.jakub.companymanagement.domain.contracts.employment.trail;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;



public class TrailEmployeeContract extends Contract implements EmploymentContract {

    //todo check if trail contract already exists for employee 

    public TrailEmployeeContract(Contract.Builder builder) {
        super(builder.getContractId(), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), new TrailEmploymentContractPeriod(builder.getFrom(), builder.getTo()));
    }
}
