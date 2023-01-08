package com.durys.jakub.companymanagement.domain.contracts.employment.permanent;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;


public class PermanentEmployeeContract extends Contract implements EmploymentContract {

    public PermanentEmployeeContract(Builder builder) {
        super(builder.getContractId(), builder.getEmployeeId(), builder.getContractNumber(),
                builder.getContractData(), todo);
    }
}
